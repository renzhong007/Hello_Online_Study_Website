package com.superz.study.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.superz.study.bean.Grade;
import com.superz.study.bean.ItemBill;
import com.superz.study.bean.Subject;
import com.superz.study.bean.User;
import com.superz.study.service.ExamService;
import com.superz.study.service.GradeService;
import com.superz.study.service.impl.ExamServiceImpl;
import com.superz.study.service.impl.GradeServiceImpl;

public class ExamAction implements RequestAware, SessionAware, ParameterAware {
	ExamService es = new ExamServiceImpl();
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Map<String, String[]> parameters;

	private GradeService gs = new GradeServiceImpl();

	private List<Grade> grades = new ArrayList<Grade>();
	private User user = new User();
	private String subjectName;
	private Integer subject;

	public String toAddItem() {
		List<Subject> allSubject = es.getAllSubject();
		request.put("allSubject", allSubject);
		return "toAddItem_success";
	}

	public String addSubject()  {
		Subject subject = new Subject();
		subject.setName(subjectName);
		es.saveSubject(subject);
		List<Subject> allSubject = es.getAllSubject();
		request.put("allSubject", allSubject);
		return "addSubject_success";
	}

	public String displayAllGrades() {
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		this.user = (User) ((Map) context.get("session")).get("user");
		this.grades = gs.getGrades(this.user, Integer.MAX_VALUE);
		request.put("grades", grades);
		return "displayAllGrades_success";
	}

	public String getTitleBill() {
		Integer sub_id = this.subject;//Integer.parseInt(this.parameters.get("subject")[0]);
		int count = es.getCount(sub_id);
		ItemBill itemBill = null;
		if (count == 0) {
			return "getTitleBill_error";
		}
		if (count < 4) {
			itemBill = es.getItemBill(count, sub_id);// 2需要获取
		} else {
			itemBill = es.getItemBill(4, sub_id);
		}
		session.put("itemBill", itemBill);
		return "getTitleBill_success";
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

}

package com.superz.study.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.superz.study.bean.User;
import com.superz.study.pojo.Answer;
import com.superz.study.pojo.Question;
import com.superz.study.service.QuestService;
import com.superz.study.service.impl.QuestServiceImpl;

@Controller("questAction")
@Scope("prototype")
public class QusetAction implements RequestAware{
	@Autowired
	private QuestService questService;

	private String content;
	private Integer id;

	private Map<String, Object> request;

	public String addAnswer() {
		System.out.println(id);
		System.out.println(content);
		Question question = this.questService.getQuestionById(id);
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateTime(new Date());
		answer.setQuestion(question);
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		User user = (User) ((Map) context.get("session")).get("user");
		answer.setTeacher(user );
		this.questService.saveAnswer(answer);
		return "addAnswer_success";
	}

	public String displayAnswer() {
		Question question = this.questService
				.getQuestionById(this.id);/* new Question(); */
		// question.setId(id);
		List<Answer> answerList = this.questService.getAllAnswer(question);
		if (answerList.size() == 0) {
			request.put("question", question);
			return "displayAnswer_error";
		}
		request.put("answerList", answerList);
		System.out.println(answerList.get(0).getQuestion().getStudent().getUsername());
		return "displayAnswer_success";
	}

	public String submit() {
		System.out.println(this.content);
		Question question = new Question();
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		User student = (User) ((Map) context.get("session")).get("user");
		Set<String> keySet = ActionContext.getContext().getValueStack().getContext().keySet();
		System.out.println(keySet);
		System.out.println(student);
		Date date = new Date();
		question.setStudent(student);
		question.setCreateTime(date);
		question.setContent(this.content);
		questService.saveQuestion(question);
		return "submit_success";
	}

	public String displayAllQuestion() {
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		User student = (User) ((Map) context.get("session")).get("user");
		List<Question> allQuestion = null;
		if(student.getStatus()==2){
			allQuestion = questService.getAllQuestion();
		}else{
			allQuestion = questService.getAllQuestion(student);
		}
		this.request.put("allQuestion", allQuestion);
		return "displayAllQuestion_success";

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}




}

package com.superz.study.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.superz.study.bean.Grade;
import com.superz.study.bean.ItemsInfo;
import com.superz.study.bean.Subject;
import com.superz.study.bean.User;
import com.superz.study.pojo.Answer;
import com.superz.study.pojo.Question;
import com.superz.study.service.ExamService;
import com.superz.study.service.GradeService;
import com.superz.study.service.QuestService;
import com.superz.study.service.UserService;
import com.superz.study.service.impl.ExamServiceImpl;
import com.superz.study.service.impl.GradeServiceImpl;
import com.superz.study.service.impl.UserServiceImpl;

@Controller
public class UserAction implements RequestAware, SessionAware, ModelDriven<User>, Preparable {
	@Autowired
	private QuestService questService;

	private Map<String, Object> session;
	private Map<String, Object> request;

	private UserService us = new UserServiceImpl();
	private ExamService es = new ExamServiceImpl();
	private GradeService gs = new GradeServiceImpl();

	private Integer id;
	private User user;
	private List<Subject> allSubject;
	private List<Grade> grades;
	private Answer Answer;

	// 封装上传文件域的属性
	private File imgUpload;
	// 封装上传文件类型的属性
	private String imgUploadContentType;
	// 封装上传文件名的属性
	private String imgUploadFileName;

	public void prepareEdit() {
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		this.user = (User) ((Map) context.get("session")).get("user");
		Set<String> keySet = session.keySet();
	}

	public String edit() {
		return "edit_success";
	}

	public String logout() {
		session.remove("user");
		return "logout_success";
	}

	public void prepareUpdate() {
		this.user = us.getUserById(this.id);
	}

	public String update() {
		if (this.imgUpload != null) {
			this.user.setImg(this.upload());
		}
		if ((this.user = us.upadateInf(this.user)) != null) {
			session.put("user", this.user);
			return "update_success";
		} else {
			return "error";
		}
	}

	public void prepareLogin() {
		this.user = new User();
		this.allSubject = new ArrayList<Subject>();
		this.grades = new ArrayList<>();
	}

	public String login() {
		this.user = us.login(this.user);
		System.out.println(this.user);
		if (this.user != null) {
			String addr = ServletActionContext.getRequest().getLocalAddr();
			this.user.setDateLastActived(new Date());
			this.user.setIpLastActived(addr);
			session.put("user", this.user);
			us.upadateInf(this.user);
			// 管理员登陆操作
			if (this.user.getStatus() == 1) {
				// 论坛信息
				// 题库信息
			}
			// 教师登陆操作
			if (this.user.getStatus() == 2) {
				// 询问信息
				Question lastQuestion = this.questService.getLastQuestion();
				request.put("lastQuestion", lastQuestion);
				// 题库信息
				ItemsInfo itemsInfo = new ItemsInfo();
				List<Subject> subjectList = es.getAllSubject();
				int subjectCount = subjectList.size();
				itemsInfo.setSubjectCount(subjectCount);
				int totleCount = 0;
				for (Subject subject : subjectList) {
					totleCount += es.getCount(subject.getId());
				}
				itemsInfo.setTotleCount(totleCount);
				List<Grade> gradeList = gs.getAllGrades();
				int doCount = gradeList.size();
				itemsInfo.setDoCount(doCount);
				double totleGrades = 0;
				for (Grade grade : gradeList) {
					totleGrades+=grade.getGrade();
				}
				double avgGrade = ((double)((int)(totleGrades/doCount*100)))/100;
				itemsInfo.setAvgGrade(avgGrade);
				request.put("itemsInfo", itemsInfo);
			}
			// 学生登陆操作
			if (this.user.getStatus() == 3) {
				// 考试信息
				// 科目 用来选择做题
				this.allSubject = es.getAllSubject();
				request.put("allSubject", allSubject);
				// 成绩显示
				this.grades = gs.getGrades(this.user, 3);
				request.put("grades", grades);
			}
			// ServletActionContext.getRequest().getSession().setMaxInactiveInterval(-1);
			return "login_success";
		} else {
			ServletActionContext.getRequest().setAttribute("msg", "用户名或密码错误！");
			return "login_error";
		}
	}

	public void prepareBack() {
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		// System.out.println(((Map)context.get("session")).keySet());
		this.user = (User) ((Map) context.get("session")).get("user");
		this.allSubject = new ArrayList<Subject>();
		this.grades = new ArrayList<>();
	}

	public String back() {
		return this.login();
	}

	private String upload() {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		String path = null;
		try {
			path = ServletActionContext.getServletContext().getRealPath("upload");
			// path =
			// ServletActionContext.getRequest().getContextPath()+"/upload";
			System.out.println(path + this.getImgUploadFileName());
			// 设置上传路径
			File saved = new File(path, getImgUploadFileName());
			saved.getParentFile().mkdirs();
			// 建立文件输出流
			fos = new FileOutputStream(saved);
			// 建立文件上传流
			fis = new FileInputStream(getImgUpload());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			System.out.println("文件上传成功");
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
			return "error";
		} finally {
			close(fos, fis);
		}
		// 改成相对路径
		// path = ServletActionContext.getRequest().getContextPath()+"/upload";
		return "/upload" + "/" + this.getImgUploadFileName();
	}

	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void prepare() throws Exception {

	}

	@Override
	public User getModel() {
		return this.user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

	// get,set方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getImgUpload() {
		return imgUpload;
	}

	public void setImgUpload(File imgUpload) {
		this.imgUpload = imgUpload;
	}

	public String getImgUploadContentType() {
		return imgUploadContentType;
	}

	public void setImgUploadContentType(String imgUploadContentType) {
		this.imgUploadContentType = imgUploadContentType;
	}

	public String getImgUploadFileName() {
		return imgUploadFileName;
	}

	public void setImgUploadFileName(String imgUploadFileName) {
		this.imgUploadFileName = imgUploadFileName;
	}

}

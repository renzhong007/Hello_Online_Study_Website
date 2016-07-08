package com.superz.study.pojo;

import java.util.Date;

import com.superz.study.bean.User;

public class Answer {
	private Integer id;
	private Question question;
	private User teacher;
	private Date createTime;
	private String content;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(Integer id, Question question, User teacher, Date createTime, String content) {
		super();
		this.id = id;
		this.question = question;
		this.teacher = teacher;
		this.createTime = createTime;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", question=" + question + ", teacher=" + teacher + ", createTime=" + createTime
				+ ", content=" + content + "]";
	}

}

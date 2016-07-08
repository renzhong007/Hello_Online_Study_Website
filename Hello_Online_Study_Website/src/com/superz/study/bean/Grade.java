package com.superz.study.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Grade {
	/*
	 * private Integer id; private Integer sub_id;
	 */
	private User user;
	private Subject subject;
	private Date date;
	private Double grade;

	private Integer user_id;
	private Integer sub_id;

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(User user, Subject subject, Date date, Double grade) {
		super();
		this.user = user;
		this.subject = subject;
		this.date = date;
		this.grade = grade;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade [user=" + user + ", subject=" + subject + ", date=" + date + ", grade=" + grade + "]";
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}

}

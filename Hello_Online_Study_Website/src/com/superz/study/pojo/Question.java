package com.superz.study.pojo;

import java.util.Date;

import com.superz.study.bean.User;

public class Question {
	private Integer id;
	private User student;
	private Date createTime;
	private String content;
	private Integer flag;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Integer id, User student, Date createTime, String content, Integer flag) {
		super();
		this.id = id;
		this.student = student;
		this.createTime = createTime;
		this.content = content;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
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

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Quest [id=" + id + ", student=" + student + ", createTime=" + createTime + ", content=" + content
				+ ", flag=" + flag + "]";
	}

}

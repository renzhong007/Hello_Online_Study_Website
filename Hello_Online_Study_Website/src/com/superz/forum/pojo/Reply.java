package com.superz.forum.pojo;

import java.util.Date;

import com.superz.study.bean.User;

public class Reply {

	private Integer id;

	private Thread thread;

	private String title;

	private String content;

	private User author;

	private int floor;

	private Date dateCreated;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(Integer id, Thread thread, String title, String content, User author, int floor, Date dateCreated) {
		super();
		this.id = id;
		this.thread = thread;
		this.title = title;
		this.content = content;
		this.author = author;
		this.floor = floor;
		this.dateCreated = dateCreated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", thread=" + thread + ", title=" + title + ", content=" + content + ", author="
				+ author + ", floor=" + floor + ", dateCreated=" + dateCreated + "]";
	}

}

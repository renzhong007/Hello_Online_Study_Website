package com.superz.forum.pojo;

import java.util.Date;

import com.superz.study.bean.User;

public class Thread {

	private Integer id;

	private String title;

	private String content;

	private User author;

	private String ipCreated;

	private int hit;

	private User authorLastReplied;

	private Date dateLastReplied;

	private Date createTime;

	private int replyCount;

	public Thread() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Thread(Integer id, Board board, String title, String content, User author, String ipCreated, int hit,
			User authorLastReplied, Date dateLastReplied, Date createTime, int replyCount) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.ipCreated = ipCreated;
		this.hit = hit;
		this.authorLastReplied = authorLastReplied;
		this.dateLastReplied = dateLastReplied;
		this.createTime = createTime;
		this.replyCount = replyCount;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getAuthorLastReplied() {
		return authorLastReplied;
	}

	public void setAuthorLastReplied(User authorLastReplied) {
		this.authorLastReplied = authorLastReplied;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateLastReplied() {
		return dateLastReplied;
	}

	public void setDateLastReplied(Date dateLastReplied) {
		this.dateLastReplied = dateLastReplied;
	}

	public String getIpCreated() {
		return ipCreated;
	}

	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Override
	public String toString() {
		return "Thread [id=" + id +  ", title=" + title + ", content=" + content + ", author="
				+ author + ", ipCreated=" + ipCreated + ", hit=" + hit + ", authorLastReplied=" + authorLastReplied
				+ ", dateLastReplied=" + dateLastReplied + ", createTime=" + createTime + ", replyCount=" + replyCount
				+ "]";
	}

	

}

package com.superz.forum.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Board {

	private Integer id;

	private String name;

	private String description;

	private int threadCount;

	private int replyCount;

	private Reply lastReply;

	private Thread lastThread;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(Integer id, String name, String description, int threadCount, int replyCount, Reply lastReply,
			Thread lastThread) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.threadCount = threadCount;
		this.replyCount = replyCount;
		this.lastReply = lastReply;
		this.lastThread = lastThread;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public Reply getLastReply() {
		return lastReply;
	}

	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

	public Thread getLastThread() {
		return lastThread;
	}

	public void setLastThread(Thread lastThread) {
		this.lastThread = lastThread;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", description=" + description + ", threadCount=" + threadCount
				+ ", replyCount=" + replyCount + ", lastReply=" + lastReply + ", lastThread=" + lastThread + "]";
	}

}

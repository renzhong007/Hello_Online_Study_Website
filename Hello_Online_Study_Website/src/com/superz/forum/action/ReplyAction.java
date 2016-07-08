package com.superz.forum.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.superz.forum.page.Page;
import com.superz.forum.pojo.Reply;
import com.superz.forum.pojo.Thread;
import com.superz.forum.service.IReplyService;
import com.superz.forum.service.IThreadService;
import com.superz.study.bean.User;

@Controller
@Scope("prototype")
public class ReplyAction implements RequestAware, SessionAware {

	@Autowired
	private IReplyService<Reply> replyService;
	@Autowired
	private IThreadService<Thread> threadService;

	private Map<String, Object> request;

	private int pageNo;
	private int id;
	private String content;
	private Map<String, Object> session;
	private int thread_id;

	// 最后一页
	private int lastPageNo = Integer.MAX_VALUE;

	
	public String deleteReply() {
		
		Reply reply = this.replyService.find(Reply.class, this.id);
		this.thread_id = reply.getThread().getId();
		this.replyService.delete(reply);
		return "deleteReply_success";
	}

	public String listAllReply() {
		String hql = "FROM Reply r where r.thread.id =" + this.id;
		List<Reply> listAllReply = this.replyService.list(hql);
		System.out.println(listAllReply);
		request.put("listAllReply", listAllReply);
		return "listAllReply_success";
	}

	public String listReply() {
		threadService.updateHit(this.id);
		int totalCount = this.replyService.getTotalCount("SELECT  count(*) FROM Reply r WHERE r.thread.id = ?",
				this.id);
		System.out.println(totalCount);
		if (totalCount > 0) {
			Page<Reply> page = new Page<>();
			page.setPageNo(this.pageNo);
			page.setCountNo(totalCount);
			String hql = "FROM Reply r  WHERE r.thread.id = ?";
			int firstResult = (page.getPageNo() - 1) * page.getPageSize();
			int maxSize = page.getPageSize();
			List<Reply> list = this.replyService.list(hql, firstResult, maxSize, this.id);
			page.setContent(list);
			this.request.put("replyPage", page);
			return "listReply_success";
		} else {
			Thread thread = this.threadService.find(Thread.class, this.id);
			this.request.put("thread", thread);
			return "listReply_not_success";
		}
	}

	public String addReply() {
		// System.out.println(this.id);
		// System.out.println(this.content);
		Reply reply = new Reply();
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		User author = (User) ((Map) context.get("session")).get("user");
		reply.setAuthor(author);
		reply.setContent(this.content);
		reply.setDateCreated(new Date());
		Thread thread = threadService.find(Thread.class, id);
		reply.setThread(thread);
		replyService.create(reply);
		return "addReply_success";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLastPageNo() {
		return lastPageNo;
	}

	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}

	public int getThread_id() {
		return thread_id;
	}

	public void setThread_id(int thread_id) {
		this.thread_id = thread_id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}

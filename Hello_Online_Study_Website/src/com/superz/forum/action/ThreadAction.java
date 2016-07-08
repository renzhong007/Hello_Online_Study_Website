package com.superz.forum.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
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
public class ThreadAction implements RequestAware {
	@Autowired
	private IThreadService<Thread> threadService;
	@Autowired
	private IReplyService<Reply> replyService;

	private int id;
	private int pageNo;
	private String content;
	private String title;

	private Map<String, Object> request;

	public String deleteThread(){
		System.out.println("-----------");
		String hql = "FROM Reply r WHERE r.thread.id = "+this.id;
		List<Reply> list = replyService.list(hql );
		for (Reply reply : list) {
			this.replyService.delete(reply);
		}
		System.out.println("=======");
		Thread thread = this.threadService.find(Thread.class, this.id);
		this.threadService.delete(thread);
		return "deleteThread_success";
	}
	
	public String addThread() {
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		User user = (User) ((Map) context.get("session")).get("user");
		System.out.println(user);
		Thread thread = new Thread();
		thread.setAuthor(user);
		thread.setContent(content);
		thread.setCreateTime(new Date());
		thread.setIpCreated(ServletActionContext.getRequest().getLocalAddr());
		thread.setTitle(title);
		System.out.println(thread);
		threadService.create(thread);
		return "addThread_success";
	}

	public String toAddThread() {
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		User user = (User) ((Map) context.get("session")).get("user");
		if (user == null) {
			return "toAddThread_error";
		}
		return "toAddThread_success";
	}

	public String listAllThread() {
		String hql = "FROM Thread t ORDER BY t.createTime DESC";
		List<Thread> allThreads = this.threadService.list(hql);
		request.put("allThread", allThreads);
		return "listAllThread_success";
	}

	public String listThread() {
		Page<Thread> page = new Page<>();
		int totalCount = this.threadService.getTotalCount("SELECT  count(*) From Thread t", null);
		System.out.println(totalCount);
		page.setPageNo(this.pageNo);
		page.setCountNo(totalCount);
		String hql = "FROM Thread t ORDER BY t.createTime DESC ";
		int firstResult = (page.getPageNo() - 1) * page.getPageSize();
		int maxSize = page.getPageSize();
		List<Thread> list = this.threadService.list(hql, firstResult, maxSize, null);
		page.setContent(list);
		this.request.put("threadPage", page);
		return "listThread_success";
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}
}

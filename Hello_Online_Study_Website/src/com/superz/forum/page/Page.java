package com.superz.forum.page;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	// 总的记录数
	private int countNo;
	// 总页数
	private int totalPage;
	// 当前页面的 List
	private List<T> content = new ArrayList<>();
	// 当前页码.
	private int pageNo;
	// 每页记录数
	private int pageSize = 4;

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int countNo, int pageSize, List<T> content, int pageNo) {
		super();
		this.countNo = countNo;
		this.pageSize = pageSize;
		this.content = content;
		this.pageNo = pageNo;
	}

	public int getCountNo() {
		return countNo;
	}

	public void setCountNo(int countNo) {
		this.countNo = countNo;
		if (this.pageNo > this.getTotalPage())
			this.pageNo = this.getTotalPage();
	}

	public int getTotalPage() {
		int totalPage = (int) this.countNo / this.pageSize;
		if (this.countNo % this.pageSize != 0)
			totalPage++;
		return totalPage;
	}

	// public void setTotalPage(int totalPage) {
	// this.totalPage = totalPage;
	// }

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		if (this.pageNo < 1)
			this.pageNo = 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Page [countNo=" + countNo + ", pageSize=" + pageSize + ", content=" + content + ", pageNo=" + pageNo
				+ ",totalPage=" + totalPage + "]";
	}

}

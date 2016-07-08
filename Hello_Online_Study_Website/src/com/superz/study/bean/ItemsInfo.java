package com.superz.study.bean;

public class ItemsInfo {
	private int subjectCount;
	private int totleCount;
	private int doCount;
	private double avgGrade;

	public ItemsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsInfo(int subjectCount, int totleCount, int doCount, double avgGrade) {
		super();
		this.subjectCount = subjectCount;
		this.totleCount = totleCount;
		this.doCount = doCount;
		this.avgGrade = avgGrade;
	}

	public int getSubjectCount() {
		return subjectCount;
	}

	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}

	public int getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}

	public int getDoCount() {
		return doCount;
	}

	public void setDoCount(int doCount) {
		this.doCount = doCount;
	}

	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}

	@Override
	public String toString() {
		return "ItemsInfo [subjectCount=" + subjectCount + ", totleCount=" + totleCount + ", doCount=" + doCount
				+ ", avgGrade=" + avgGrade + "]";
	}

}

package com.superz.study.bean;

public class Subject {
	private Integer id;
	private String name;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return id+"."+name;
	}

}

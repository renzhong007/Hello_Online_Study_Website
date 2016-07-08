package com.superz.study.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superz.study.bean.User;

public class PersonUtil {

	public static final String PERSON_INFO = "personInfo";

	public static PersonInfo getPersonInfo(HttpServletRequest request,
			HttpServletResponse response) {

		return (PersonInfo) request.getSession(true).getAttribute(PERSON_INFO);
	}

	public static void setPersonInf(HttpServletRequest request,
			HttpServletResponse response, PersonInfo personInfo) {

		request.getSession(true).setAttribute(PERSON_INFO, personInfo);
	}

	public static void setPersonInf(HttpServletRequest request,
			HttpServletResponse response, User person) {

		PersonInfo personInfo = new PersonInfo();

		personInfo.setId(person.getId());
		personInfo.setAccount(person.getUsername());

		setPersonInf(request, response, personInfo);
	}
}

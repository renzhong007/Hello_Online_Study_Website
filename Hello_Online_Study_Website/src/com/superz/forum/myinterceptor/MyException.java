package com.superz.forum.myinterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyException extends AbstractInterceptor {
	
	String result="error";

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		try{

			result=arg0.invoke();

			}catch(Exception e){

				e.printStackTrace();

			}
		return result;
		
	}

}

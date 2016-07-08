package com.superz.study.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * BeanUtils实现类，封装web基本操作的工具类
 * 
 * @author RZ_Jackson
 *
 */
public class WEBUtils {

	/**
	 * 将请求参数封装到相应的Bean对象中
	 * 
	 * @param request
	 * @param t
	 * @return
	 */
	public static <T> T param2Bean(HttpServletRequest request, T t) {
		//获取一个map对象
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}

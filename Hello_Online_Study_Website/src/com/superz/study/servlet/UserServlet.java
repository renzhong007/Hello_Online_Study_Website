package com.superz.study.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.superz.study.bean.User;
import com.superz.study.service.UserService;
import com.superz.study.service.impl.UserServiceImpl;
import com.superz.study.utils.WEBUtils;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private UserService us = new UserServiceImpl();

	/**
	 * 实现用户登陆操作
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User u = WEBUtils.param2Bean(request, new User());
		HttpSession session = request.getSession();
		u.setIpLastActived(request.getRemoteAddr());
		u.setDateLastActived(new Date());
		User user = us.login(u);
		if (user == null) {
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			System.out.println(user);
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/forum.jsp");

	}

	/**
	 * 实现用户注册操作
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String c = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// 从请求参数总获取验证码的值，即用户填入的那个.
		String parm = (String) request.getParameter("kaptchafield");

		// 比较两个值是否一致.
		if (!c.equals(parm)) {
			request.setAttribute("msg", "验证码错误!");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			return;
		}

		User user = WEBUtils.param2Bean(request, new User());
		user.setIpCreated(request.getRemoteAddr());
		user.setIpLastActived(request.getRemoteAddr());
		user.setDateCreated(new Date());
		user.setDateLastActived(new Date());
		user.setImg("/static/img/default.jpg");
		user.setStatus(3);
		if (us.regist(user))

		{
		
			response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
		} else

		{
			request.setAttribute("msg", "该用户名已存在!");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

		}
	}
	
	
	protected void valiateUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);
		int i = us.getUsernameByUsername(username);
		response.getWriter().print(i);
	}
	
	protected void updateInf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = WEBUtils.param2Bean(request, new User());
		User user = us.upadateInf(u);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
	}

}

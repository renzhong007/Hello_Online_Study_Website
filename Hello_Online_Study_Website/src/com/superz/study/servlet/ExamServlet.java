package com.superz.study.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.RequestAware;

import com.superz.study.bean.Grade;
import com.superz.study.bean.Item;
import com.superz.study.bean.ItemBill;
import com.superz.study.bean.Subject;
import com.superz.study.bean.User;
import com.superz.study.service.ExamService;
import com.superz.study.service.GradeService;
import com.superz.study.service.impl.ExamServiceImpl;
import com.superz.study.service.impl.GradeServiceImpl;
import com.superz.study.utils.WEBUtils;

/**
 * Servlet implementation class ExamServlet
 */
public class ExamServlet extends BaseServlet {
	
	private final int ITEM_COUNT = 4;

	private ExamService es = new ExamServiceImpl();
	private GradeService gs = new GradeServiceImpl();
	private Map<String, Object> request;

	private static final long serialVersionUID = 1L;

	/**
	 * 实现生成随机题单
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getTitleBill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Integer sub_id = Integer.parseInt(request.getParameter("subject"));
		int count = es.getCount(sub_id);
		ItemBill itemBill = null;
		if(count==0){
			response.sendRedirect(request.getContextPath() + "/pages/exam/exam_error.jsp");
			return;
		}
		if(count<ITEM_COUNT){
			itemBill = es.getItemBill(count, sub_id);// 2需要获取			
		}else{
			itemBill = es.getItemBill(ITEM_COUNT, sub_id);
		}
		session.setAttribute("itemBill", itemBill);
		response.sendRedirect(request.getContextPath() + "/pages/exam/exam.jsp");
	}

	protected void getGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ItemBill itemBill = (ItemBill) session.getAttribute("itemBill");
		Iterator<Item> iter = itemBill.getBill().values().iterator();
		int i = 1;
		int sub_id = 0;
		while (iter.hasNext()) {
			Item item = iter.next();
			item.setResult(request.getParameter("" + i));
			sub_id = item.getSubject_id();
			i++;
		}

		double grade = es.getGrade(itemBill);

		// 保存成绩
		Grade g = new Grade();
		User user = (User) session.getAttribute("user");
		Subject subject = es.getSubjectBySubjectId(sub_id);
		
		g.setUser(user);
		g.setSubject(subject);
		g.setDate(new Date());
		g.setGrade(grade);
		System.out.println(g);
		gs.saveGrade(g);

		request.setAttribute("grade", grade);
		request.getRequestDispatcher("/pages/exam/exam.jsp").forward(request, response);
	}

	protected void saveTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Item item = WEBUtils.param2Bean(request, new Item());
		if (es.saveItem(item)) {
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/pages/exam/save_title.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/pages/exam/save_title.jsp").forward(request, response);
		}
	}

}

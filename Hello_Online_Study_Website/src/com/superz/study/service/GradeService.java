package com.superz.study.service;

import java.util.List;

import com.superz.study.bean.Grade;
import com.superz.study.bean.User;

public interface GradeService {

	/**
	 * 存成绩
	 * 
	 * @param grade
	 * @return
	 */
	boolean saveGrade(Grade grade);

	/**
	 * 显示指定个数成绩
	 * 
	 * @return
	 */
	List<Grade> getGrades(User user, int num);

	/**
	 * 获取所有成绩
	 * 
	 * @return
	 */
	List<Grade> getAllGrades();

}

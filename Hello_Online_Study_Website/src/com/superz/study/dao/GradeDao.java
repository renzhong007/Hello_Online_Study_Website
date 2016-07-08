package com.superz.study.dao;

import java.util.List;

import com.superz.study.bean.Grade;
import com.superz.study.bean.User;

public interface GradeDao {
	/**
	 * 存成绩
	 * 
	 * @param grade
	 * @return
	 */
	boolean saveGrade(Grade grade);

	/**
	 * 获得所有成绩
	 * 
	 * @return
	 */
	List<Grade> getGrades(User user, int num);

	/**
	 * 获取所有grade对象
	 * 
	 * @return
	 */
	List<Grade> getAllGrades();

}

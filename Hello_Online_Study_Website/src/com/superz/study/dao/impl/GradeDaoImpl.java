package com.superz.study.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.superz.study.bean.Grade;
import com.superz.study.bean.User;
import com.superz.study.dao.BaseDao;
import com.superz.study.dao.GradeDao;

public class GradeDaoImpl extends BaseDao<Grade> implements GradeDao {

	@Override
	public boolean saveGrade(Grade grade) {
		String sql = "insert into grade (id,sub_id,date,grade) values(?,?,?,?) ";
		return this.update(sql, grade.getUser().getId(), grade.getSubject().getId(), grade.getDate(),
				grade.getGrade()) == 1;
	}

	@Override
	public List<Grade> getGrades(User user, int num) {
		String sql = "select  * from grade where id =?  ORDER BY date DESC  limit 0 ,? ";
		return this.queryAll(sql, user.getId(),num);
	}

	@Override
	public List<Grade> getAllGrades() {
		String sql = "select * from grade";
		return this.queryAll(sql, null);
	}

}

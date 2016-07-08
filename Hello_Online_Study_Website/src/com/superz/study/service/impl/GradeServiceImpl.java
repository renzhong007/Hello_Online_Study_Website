package com.superz.study.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.superz.study.bean.Grade;
import com.superz.study.bean.Subject;
import com.superz.study.bean.User;
import com.superz.study.dao.GradeDao;
import com.superz.study.dao.UserDao;
import com.superz.study.dao.impl.GradeDaoImpl;
import com.superz.study.dao.impl.SubjectDaoImpl;
import com.superz.study.dao.impl.UserDaoImpl;
import com.superz.study.service.GradeService;

public class GradeServiceImpl implements GradeService {

	private GradeDao gd = new GradeDaoImpl();
	private SubjectDaoImpl sd = new SubjectDaoImpl();
	private UserDao ud = new UserDaoImpl();

	@Override
	public boolean saveGrade(Grade grade) {
		return gd.saveGrade(grade);
	}

	@Override
	public List<Grade> getGrades(User user, int num) {
		List<Grade> grades = new ArrayList<>();
		Iterator<Grade> iter = gd.getGrades(user,num).iterator();
		while (iter.hasNext()) {
			Grade grade = (Grade) iter.next();
			Subject s = sd.getSubjectBySubjectId(grade.getSub_id());
			grade.setUser(user);
			grade.setSubject(s);
			grades.add(grade);
		}
		return grades;
	}

	@Override
	public List<Grade> getAllGrades() {
		return gd.getAllGrades();
	}

}

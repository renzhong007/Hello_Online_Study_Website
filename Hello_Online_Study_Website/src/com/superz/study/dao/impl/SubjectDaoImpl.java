package com.superz.study.dao.impl;

import java.util.List;

import com.superz.study.bean.Item;
import com.superz.study.bean.Subject;
import com.superz.study.dao.BaseDao;

public class SubjectDaoImpl extends BaseDao<Subject> {
	public List<Subject> getAllSubject() {
		String sql = "select * from subject";
		return this.queryAll(sql);
	}

	public Subject getSubjectBySubjectId(int sub_id) {
		String sql = "select * from subject where id = ?";
		return this.query(sql, sub_id);
	}

	public void saveSubject(Subject subject) {
		String find = "select count(*) from subject where name = '"+subject.getName()+"'";
		if(this.count(find)!=0){
			return;
		}
		String save = "INSERT INTO `subject` (NAME) VALUES ('"+subject.getName()+"')";
		this.update(save, null);
		Subject s = this.query("select * from subject where name = ?", subject.getName());
		String create = "CREATE TABLE  item"+s.getId()+" (   "
				+ "id INT NOT NULL AUTO_INCREMENT,  "
				+ "title VARCHAR(200), "
				+ "optionA VARCHAR(200), "
				+ "optionB VARCHAR(200),  "
				+ "optionC VARCHAR(200),  "
				+ "optionD VARCHAR(200),  "
				+ "answer  VARCHAR(10),  "
				+ "subject_id INT,  "
				+ "PRIMARY KEY (id),  "
				+ "FOREIGN KEY (subject_id) REFERENCES  subject(id))";
		this.update(create, null);
	}


}

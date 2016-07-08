package com.superz.study.dao.impl;

import java.util.List;

import com.superz.study.bean.Item;
import com.superz.study.bean.Subject;
import com.superz.study.dao.BaseDao;
import com.superz.study.dao.ExamDao;

/**
 * ExamDao的实现类
 * 
 * @author RZ_Jackson
 *
 */
public class ExamDaoImpl extends BaseDao<Item> implements ExamDao {

	@Override
	public Item getItemByInfo(Integer id, Integer subject_id) {
		String sql = "select * from item" + subject_id + " where id = ?";
		return this.query(sql, id);
	}

	@Override
	public boolean setItem(Item item) {
		String sql = "insert into item" + item.getSubject_id()
				+ " (id,title,optionA,optionB,optionC,optionD,answer,subject_id) values (?,?,?,?,?,?,?,?)";
		return this.update(sql, item.getId(), item.getTitle(), item.getOptionA(), item.getOptionB(), item.getOptionC(),
				item.getOptionD(), item.getAnswer(), item.getSubject_id()) == 1;
	}

	@Override
	public int getCount(Integer subject_id) {
		String sql = "SELECT COUNT(*) FROM item" + subject_id;
		return this.count(sql);
	}

	@Override
	public boolean updateId(Integer subject_id) {
		String sql1 = "ALTER TABLE item" + subject_id + " DROP id";
		String sql2 = "ALTER TABLE item" + subject_id + " ADD COLUMN `id` INT " + "NOT NULL " + "AUTO_INCREMENT FIRST, "
				+ "ADD PRIMARY KEY (`id`)";
		this.update(sql1);
		return this.update(sql2) == 1;
	}

	public List<Item> getAllItemBySubjectId(Integer id) {
		String sql = "select * from item" + id;
		return this.queryAll(sql, null);
	}

	public void delect(Item item) {
		String sql = "DELETE FROM item" + item.getSubject_id() + " WHERE id = ?";
		this.update(sql, item.getId());
	}

	public void updateItem(Item item) {
		String sql = "UPDATE item" + item.getSubject_id()
				+ "  SET title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=?  " + "WHERE id=?";
		this.update(sql, item.getTitle(), item.getOptionA(), item.getOptionB(), item.getOptionC(), item.getOptionD(),
				item.getAnswer(), item.getId());
	}

}

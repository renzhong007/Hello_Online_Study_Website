package com.superz.study.dao;

import java.util.List;

import com.superz.study.bean.Item;
import com.superz.study.bean.Subject;

/**
 * 数据库基本操作接口
 * 
 * @author RZ_Jackson
 *
 */
public interface ExamDao {


	/**
	 * 根据id获取题目
	 * 
	 * @param id
	 * @return
	 */
	Item getItemByInfo(Integer id, Integer subject_id);

	/**
	 * 向数据库中添加题目
	 * 
	 * @param item
	 * @return
	 */
	boolean setItem(Item item);

	/**
	 * 获取数据库数据条数
	 * 
	 * @return
	 */
	int getCount(Integer subject_id);

	/**
	 * 更新id
	 * 
	 * @return
	 */
	boolean updateId(Integer subject_id);

}

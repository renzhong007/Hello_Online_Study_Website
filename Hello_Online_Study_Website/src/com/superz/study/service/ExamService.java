package com.superz.study.service;

import java.util.List;

import com.superz.study.bean.Item;
import com.superz.study.bean.ItemBill;
import com.superz.study.bean.Subject;
import com.superz.study.bean.User;

/**
 * 定义用户业务相关接口
 * 
 * @author RZ_Jackson
 *
 */
public interface ExamService {

	/**
	 * 获取所有课程
	 * 
	 * @return
	 */
	List<Subject> getAllSubject();

	/**
	 * 通过id获得题目
	 * 
	 * @param id
	 * @return
	 */
	Item getItemById(Integer id, Integer subject_id);

	/**
	 * 获取指定题数的试卷
	 * 
	 * @return
	 */
	ItemBill getItemBill(int n, Integer subject_id);

	/**
	 * 存题目
	 * 
	 * @param item
	 * @return
	 */
	boolean saveItem(Item item);

	/**
	 * 批量存题
	 * 
	 * @param list
	 * @return
	 */
	boolean saveItems(List<Item> list);

	/**
	 * 得到题库中题目总数
	 * 
	 * @return
	 */
	int getCount(Integer subject_id);

	/**
	 * 批改试卷
	 * 
	 * @param itemBill
	 * @param result
	 * @return
	 */
	double getGrade(ItemBill itemBill);

	/**
	 * 根据id获取subject
	 * 
	 * @param sub_id
	 * @return
	 */
	Subject getSubjectBySubjectId(int sub_id);

	/**
	 * 创建subject
	 * 
	 * @param subject
	 * @return
	 */
	void saveSubject(Subject subject);

	/**
	 * 获取指定科目所有题目
	 * 
	 * @param id
	 * @return
	 */
	List<Item> getAllItemBySubjectId(Integer id);

	/**
	 * 删除item对象
	 * 
	 * @param item
	 */
	void delect(Item item);

	/**
	 * 更新item对象
	 * 
	 * @param item
	 */
	void updateItem(Item item);

}

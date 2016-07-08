package com.superz.study.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.superz.study.bean.Item;
import com.superz.study.bean.ItemBill;
import com.superz.study.bean.Subject;
import com.superz.study.dao.impl.ExamDaoImpl;
import com.superz.study.dao.impl.SubjectDaoImpl;
import com.superz.study.service.ExamService;

/**
 * ExamService接口的实现类
 * 
 * @author RZ_Jackson
 *
 */
public class ExamServiceImpl implements ExamService {

	private ExamDaoImpl edi = new ExamDaoImpl();
	private SubjectDaoImpl sdi = new SubjectDaoImpl();

	private int count;

	public ExamServiceImpl() {

	}

	/**
	 * 产生n个不同的题号
	 * 
	 * @param n
	 * @return
	 */
	private int[] getRandom(int n, Integer subject_id) {
		this.count = this.getCount(subject_id);
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			int num = (int) (Math.random() * count + 1);
			System.out.print("======" + num + "\t");
			if (this.equal(arr, num)) {
				arr[i] = num;
			} else {
				i--;
			}
			System.out.println(i + "-----" + arr[i]);
		}
		return arr;
	}

	private boolean equal(int[] arr, int num) {
		int i = 0;
		while (arr[i] != 0) {
			if (arr[i] == num) {
				return false;
			}
			i++;
		}
		return true;
	}

	/**
	 * 根据id获取相应的题目
	 */
	@Override
	public Item getItemById(Integer id, Integer subject_id) {
		// TODO Auto-generated method stub
		return edi.getItemByInfo(id, subject_id);
	}

	/**
	 * 生成随机题单
	 */
	@Override
	public ItemBill getItemBill(int n, Integer subject_id) {
		ItemBill itemBill = new ItemBill();
		edi.updateId(subject_id);
		int[] randomId = this.getRandom(n, subject_id);
		for (int id : randomId) {
			itemBill.setBill(this.getItemById(id, subject_id));
		}

		return itemBill;

	}

	/**
	 * 存储题目
	 */
	@Override
	public boolean saveItem(Item item) {
		// TODO Auto-generated method stub
		return edi.setItem(item);
	}

	@Override
	public int getCount(Integer subject_id) {
		return edi.getCount(subject_id);
	}

	@Override
	/**
	 * 批量添加题
	 */
	public boolean saveItems(List<Item> items) {
		boolean flag = true;
		Iterator<Item> iter = items.iterator();

		while (iter.hasNext() && flag == true) {
			Item item = iter.next();
			flag = edi.setItem(item);
		}

		return flag;
	}

	@Override
	/**
	 * 批改试题
	 */
	public double getGrade(ItemBill itemBill) {
		double singleItem = 100 / itemBill.getBill().size();
		double countRight = 0;
		Iterator<Item> iter = itemBill.getBill().values().iterator();
		while (iter.hasNext()) {
			Item item = iter.next();

			System.out.println(item.getAnswer() + "=====" + item.getResult());
			if (item.getAnswer().equals(item.getResult())) {
				countRight += singleItem;
			}
		}
		System.out.println(countRight);
		return countRight;
	}

	@Override
	public List<Subject> getAllSubject() {
		return sdi.getAllSubject();
	}

	@Override
	public Subject getSubjectBySubjectId(int sub_id) {
		return sdi.getSubjectBySubjectId(sub_id);
	}

	@Override
	public void saveSubject(Subject subject) {
		sdi.saveSubject(subject);
	}

	@Override
	public List<Item> getAllItemBySubjectId(Integer id) {
		return edi.getAllItemBySubjectId(id);
	}

	@Override
	public void delect(Item item) {
		edi.delect(item);
	}

	@Override
	public void updateItem(Item item) {
		edi.updateItem(item);
	}


}

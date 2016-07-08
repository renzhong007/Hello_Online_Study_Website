package com.superz.forum.service;

import java.util.List;

import org.hibernate.Query;

/**
 * Service接口，基本方法
 * 
 * @author RZ_Jackson
 *
 * @param <T>
 */
public interface IService<T> {
	// 根据id查找实体
	public T find(Class<T> clazz, int id);

	// 创建实体
	public void create(T baseBean);

	// 保存实体
	public void save(T baseBean);

	// 删除实体
	public void delete(T baseBean);

	// 查询所有实体
	public List<T> list(String hql);

	// 查询页数
	public int getTotalCount(String hql, Object... params);

	// 分页实体
	public List<T> list(String hql, int firstResult, int maxSize, Object... params);
	
	public Query createQuery(String hql);
}

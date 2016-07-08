package com.superz.forum.dao;

import java.util.List;

import org.hibernate.Query;

/**
 * Dao接口，使用泛型，操作所有实体
 * 
 * @author RZ_Jackson
 *
 * @param <T>
 */
public interface IDao<T> {
	//根据id查询实体
	public T find(Class<T> clazz, int id);
	//创建实体
	public void create(T baseBean);
	//保存实体
	public void save(T baseBean);
	//删除实体
	public void delete(T baseBean);
	//查询实体
	public List<T> list(String hql);
	//查询总数
	public int getTotalCount(String hql,Object...params);
	//查询某页实体
	public List<T> list(String hql,int firstResult,int maxSize,Object...params);
	//查询Query对象
	public Query createQuery(String hql);
}

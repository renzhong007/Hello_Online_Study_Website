package com.superz.forum.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.superz.forum.dao.IDao;
import com.superz.forum.service.IService;

@Transactional
public abstract class ServiceImpl<T> implements IService<T> {
	@Autowired
	protected IDao<T> dao;

	public IDao<T> getDao() {
		return dao;
	}

	public void setDao(IDao<T> dao) {
		this.dao = dao;
	}

	public T find(Class<T> clazz, int id) {
		return dao.find(clazz, id);
	}

	public abstract void create(T baseBean);

	public void delete(T baseBean) {
		dao.delete(baseBean);
	}

	public int getTotalCount(String hql, Object... params) {
		return dao.getTotalCount(hql, params);
	}

	public void save(T baseBean) {
		dao.save(baseBean);
	}

	public List<T> list(String hql) {
		return dao.list(hql);
	}

	public List<T> list(String hql, int firstResult, int maxSize, Object... params) {
		return dao.list(hql, firstResult, maxSize, params);
	}
	
	public Query createQuery(String hql) {
		return dao.createQuery(hql);
		
	}

}

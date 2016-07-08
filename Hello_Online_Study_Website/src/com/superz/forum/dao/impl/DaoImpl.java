package com.superz.forum.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.superz.forum.dao.IDao;

@Repository
public class DaoImpl<T> implements IDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public T find(Class<T> clazz, int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	public void create(T baseBean) {
		sessionFactory.getCurrentSession().persist(baseBean);
	}

	public Query createQuery(String hql) {
		return  sessionFactory.getCurrentSession().createQuery(hql);
	}

	public void delete(T baseBean) {
		 sessionFactory.getCurrentSession().delete(baseBean);
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {
		return  sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public int getTotalCount(String hql, Object... params) {
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++)
			query.setParameter(i, params[i]);
		Object obj = query.uniqueResult();
		return ((Long) obj).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, int firstResult, int maxResults, Object... params) {
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++)
			query.setParameter(i, params[i]);
		List<T> list = query.setFirstResult(firstResult).setMaxResults(maxResults).list();
		return list;
	}

	public void save(T baseBean) {
		 sessionFactory.getCurrentSession().save(baseBean);
	}

}

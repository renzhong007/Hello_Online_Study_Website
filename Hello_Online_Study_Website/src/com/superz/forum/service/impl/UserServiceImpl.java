package com.superz.forum.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.superz.forum.service.IUserService;
import com.superz.study.bean.User;
import com.superz.study.util.MD5Util;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl<T extends User> extends ServiceImpl<T> implements IUserService<T> {
	@SuppressWarnings("unchecked")
	public T findUserByAccount(String account) {

		List<T> User = this.getDao()
				.createQuery(
						" select p from User p " + " where lower(p.account) = lower(:account) and deleted = false ")
				.setParameter("account", account.trim()).list();

		if (User.size() > 0)
			return User.get(0);

		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void create(T User) {

		if (findUserByAccount(User.getUsername()) != null) {
			throw new RuntimeException("帐号 " + User.getUsername() + " 已经存在。");
		}

		User.setPassword(MD5Util.calc(User.getPassword()));

		this.getDao().create(User);
	}

	public T getUser(String account, String password) {

		List<T> list = this.getDao()
				.createQuery(" select p from User p where p.account = :account "
						+ " and p.password = :password and p.deleted = false ")
				.setParameter("account", account).setParameter("password", MD5Util.calc(password)).list();

		if (list.size() > 0)
			return list.get(0);
		return null;
	}
}

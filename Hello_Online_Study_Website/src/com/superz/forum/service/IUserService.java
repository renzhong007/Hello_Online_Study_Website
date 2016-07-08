package com.superz.forum.service;

import com.superz.study.bean.User;

public interface IUserService<T extends User> extends IService<T> {

	/** 根据帐号查找用户 */
	public T findUserByAccount(String account);

	/** 根据帐号、密码查找用户 */
	public T getUser(String account, String password);

}

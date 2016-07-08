package com.superz.study.service.impl;


import java.util.List;

import com.superz.study.bean.User;
import com.superz.study.dao.UserDao;
import com.superz.study.dao.impl.UserDaoImpl;
import com.superz.study.service.UserService;

/**
 * UserService的实现类
 * 
 * @author RZ_Jackson
 *
 */
public class UserServiceImpl implements UserService {
	private UserDao ud = new UserDaoImpl();

	@Override
	public User login(User user) {
		return ud.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		return ud.saveUser(user);
	}

	@Override
	public int getUsernameByUsername(String username) {
		return ud.getUsername(username);
	}

	@Override
	public User upadateInf(User user) {
		return ud.updateInf(user);
	}

	@Override
	public List<User> getAllStudent() {
		return ud.getAllBill(3);
	}
	
	@Override
	public List<User> getAllTeacher() {
		return ud.getAllBill(2);
	}

	@Override
	public boolean deleteUserById(Integer id) {
		return ud.deleteUserById(id);
		
	}

	@Override
	public User getUserById(Integer id) {
		return ud.getUserById(id);
	}

	@Override
	public List<User> getUsersByStatus(int status) {
		return ud.getAllBill(status);
	}

	

}

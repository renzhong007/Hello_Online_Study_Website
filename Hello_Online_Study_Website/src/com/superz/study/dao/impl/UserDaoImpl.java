package com.superz.study.dao.impl;

import java.util.Date;
import java.util.List;

import com.superz.study.bean.User;
import com.superz.study.dao.BaseDao;
import com.superz.study.dao.UserDao;

/**
 * UserDao实现类
 * 
 * @author RZ_Jackson
 *
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(User user) {
		String sql = "select * from user where username = ? and password = ? and deleted=0";
		return this.query(sql, user.getUsername(), user.getPassword());
	}

	@Override
	public boolean saveUser(User user) {
		String sql = "insert into user (status,id,username,  password,  sex,  realname,  img,  email, ipLastActived, ipCreated,  dateLastActived, dateCreated) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		return this.update(sql, user.getStatus(), user.getId(), user.getUsername(), user.getPassword(), user.getSex(),
				user.getRealname(), user.getImg(), user.getEmail(), user.getIpLastActived(), user.getIpCreated(),
				user.getDateLastActived(), user.getDateCreated()) == 1;
	}

	@Override
	public int getUsername(String username) {
		String sql = "select * from user where username = ? and deleted=0";
		System.out.println(username);
		System.out.println(this.query(sql, username));
		if (this.query(sql, username) != null)
			return 1;
		else
			return 0;
	}

	@Override
	public User updateInf(User user) {
		String sql = " UPDATE USER   SET img = ?,`dateLastActived`=?,`ipLastActived`=?, `username` = ?, `password`=?,`email`=?,`sex`=?,`realname`=?  WHERE id = ?";
		this.update(sql,user.getImg(), user.getDateLastActived(), user.getIpLastActived(), user.getUsername(), user.getPassword(),
				user.getEmail(), user.getSex(), user.getRealname(), user.getId());
		return this.getUserById(user.getId());
	}

	@Override
	public User getUserById(Integer id) {
		String sql = "select * from user where id =? and deleted=0";
		return this.query(sql, id);
	}

	@Override
	public List<User> getAllBill(Integer status) {
		String sql = "select * from user where status = ? and deleted=0";
		return this.queryAll(sql, status);
	}

	@Override
	public List<User> find(int start, int pageSize) {
		String sql = "select * from user where  status = 3 and deleted=0  limit ?,?";
		return this.queryAll(sql, start, pageSize);
	}

	@Override
	public boolean deleteUserById(Integer id) {
		String sql = "UPDATE USER SET deleted=1 WHERE id=?";
		return this.update(sql, id) == 1;
	}

	

}

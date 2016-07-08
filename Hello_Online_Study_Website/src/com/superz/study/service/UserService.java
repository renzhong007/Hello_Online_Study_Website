package com.superz.study.service;

import java.util.List;

import com.superz.study.bean.User;

/**
 * 定义用户相关业务接口
 * 
 * @author RZ_Jackson
 *
 */
public interface UserService {
	/**
	 * 登陆操作
	 * 
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 注册操作
	 * 
	 * @param user
	 * @return
	 */
	boolean regist(User user);

	/**
	 * 校验用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	int getUsernameByUsername(String username);

	/**
	 * 更新个人信息
	 * 
	 * @param u
	 * @return
	 */
	User upadateInf(User user);

	/**
	 * 获取所有学生
	 * 
	 * @return
	 */
	List<User> getAllStudent();

	/**
	 * 根据id删除user
	 * 
	 * @param id
	 */
	boolean deleteUserById(Integer id);

	/**
	 * 根据id获取user
	 * 
	 * @param id
	 * @return
	 */

	User getUserById(Integer id);

	/**
	 * 获取所有老师
	 * 
	 * @param id
	 * @return
	 */
	List<User> getAllTeacher();

	/**
	 * 根据status获取users
	 * 
	 * @param status
	 * @return
	 */
	List<User> getUsersByStatus(int status);

}

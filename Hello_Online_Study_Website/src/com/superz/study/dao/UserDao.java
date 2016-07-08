package com.superz.study.dao;

import java.util.List;

import com.superz.study.bean.User;

/**
 * 定义相关数据库操作的接口
 * 
 * @author RZ_Jackson
 *
 */
public interface UserDao {
	/**
	 * 根据username和password查询user对象
	 * 
	 * @param user
	 * @return
	 */
	User getUserByUsernameAndPassword(User user);

	/**
	 * 存储user对象
	 * 
	 * @param user
	 * @return
	 */
	boolean saveUser(User user);

	/**
	 * 检测名字是否被占用
	 * 
	 * @param username
	 * @return
	 */
	int getUsername(String username);

	/**
	 * 更新信息
	 * 
	 * @param u
	 * @return
	 */
	User updateInf(User user);

	/**
	 * 根据id获取user
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);

	/**
	 * 获取所有名单
	 * 
	 * @return
	 */
	List<User> getAllBill(Integer status);

	/**
	 * 分页获取学生
	 * 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<User> find(int start, int pageSize);

	/**
	 * 根据id删除user
	 * 
	 * @param id
	 */
	boolean deleteUserById(Integer id);


}

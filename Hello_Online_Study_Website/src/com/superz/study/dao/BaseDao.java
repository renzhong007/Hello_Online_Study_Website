package com.superz.study.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.xml.transform.Source;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.superz.study.bean.Grade;
import com.superz.study.utils.JDBCUtils;

/**
 * 定义数据库基本操作的Dao，供其他Dao继承
 * 
 * @author RZ_Jackson
 *
 * @param <T>
 */
public class BaseDao<T> {
	private QueryRunner runner = new QueryRunner();

	private Class<T> type;

	public BaseDao() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	/**
	 * 查询
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public T query(String sql, Object... params) {
		T t = null;
		Connection con = JDBCUtils.getConnection();
		try {
			t = runner.query(con, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con);
		}
		return t;
	}

	public List<T> queryAll(String sql, Object... params) {
		List<T> t = null;
		Connection con = JDBCUtils.getConnection();
		try {
			t = runner.query(con, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con);
		}
		return t;
	}
	/**
	 * 增删改
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		int count = 0;
		Connection con = JDBCUtils.getConnection();
		try {
			count = runner.update(con, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con);
		}
		return count;
	}

	/**
	 * 查询数据条数
	 * 
	 * @param sql
	 * @return
	 */
	public int count(String sql) {
		long count = 0;
		Connection con = JDBCUtils.getConnection();
		try {
			count = runner.query(con, sql, new ScalarHandler<Long>());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con);
		}
		return (int) count;
	}

	
}

package com.superz.study.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接工具
 * 
 * @author RZ_Jackson
 *
 */
public class JDBCUtils {

	// 获取数据源（DataSource）comboPooledDataSource
	private static DataSource source = new ComboPooledDataSource();

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭连接
	 * 
	 * @param con
	 */
	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

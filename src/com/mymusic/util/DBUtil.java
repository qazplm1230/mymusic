package com.mymusic.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用c3p0获取连接对象和归还连接对象的工具类
 * @author 
 *
 */
public class DBUtil {

	//定义数据源对象
	public static DataSource ds;
	
	static{
		//创建数据源对象
		ds = new ComboPooledDataSource("mysql");
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 归还关闭连接
	 * @param conn
	 */
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

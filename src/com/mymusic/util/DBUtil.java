package com.mymusic.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ʹ��c3p0��ȡ���Ӷ���͹黹���Ӷ���Ĺ�����
 * @author 
 *
 */
public class DBUtil {

	//��������Դ����
	public static DataSource ds;
	
	static{
		//��������Դ����
		ds = new ComboPooledDataSource("mysql");
	}
	
	/**
	 * ��ȡ����
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
	 * �黹�ر�����
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

package com.mymusic.dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mymusic.dao.UserDao;
import com.mymusic.entity.User;
import com.mymusic.util.DBUtil;
/**
 * ʵ����
 * �����û��ĸ������ݿ����
 * @author 
 *
 */
public class UserDaoImpl implements UserDao{

	/**
	 * �����ã��û��������룩��ѯ����һ���û���ȫ����Ϣ
	 * @param userName	�û���
	 * @param pwd	����
	 * @return	��Ӧ���û�ȫ����Ϣ
	 */
	@Override
	public User queryUser(String userName, String pwd) {
		String sql = "select * from user where u_loginId=? and u_loginPwd=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		User user = null;
		try {
			user  = (User) runner.query(sql, new BeanHandler(User.class), userName,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ���û����в���һ������
	 * @param user	һ��user����
	 */
	@Override
	public int insertOne(User user) {
		String sql = "insert into user(u_loginId,u_loginPwd,u_userName,u_sex,u_photo,u_userType) values(?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			runner.execute(sql,user.getU_loginId(),user.getU_loginPwd(),user.getU_userName(),user.getU_sex(),user.getU_photo(),user.getU_userType());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * ͨ���û���Ų�ѯ���û�
	 * @param u_id	�û����
	 * @return	���û�
	 */
	@Override
	public User queryUserById(int u_id) {
		String sql = "select * from user where u_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		User user = null;
		try {
			user = (User) runner.query(sql, new BeanHandler(User.class),u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
   //�û����Ͳ鿴
	@Override
	public int queryUserType(String u_loginId, String u_loginPwd) {
		int n=0;
		try {			
			String sql="select u_userType from user where u_loginId=? and u_loginPwd=?";
			//Object[] param= {u_loginId,u_loginPwd};
			//Connection conn=DBUtil.getConnection();
			//QueryRunner run =new QueryRunner();
			QueryRunner runner = new QueryRunner(DBUtil.ds);
			 n= (int) runner.query(sql,new ScalarHandler(),u_loginId,u_loginPwd);
			
		    //conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}

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
 * 实现类
 * 进行用户的各种数据库操作
 * @author 
 *
 */
public class UserDaoImpl implements UserDao{

	/**
	 * 根据用（用户名，密码）查询返回一个用户的全部信息
	 * @param userName	用户名
	 * @param pwd	密码
	 * @return	对应的用户全部信息
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
	 * 往用户表中插入一条数据
	 * @param user	一个user对象
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
	 * 通过用户编号查询该用户
	 * @param u_id	用户编号
	 * @return	该用户
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
	
   //用户类型查看
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

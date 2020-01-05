package com.mymusic.dao;


import com.mymusic.entity.User;

/**
 * 接口类
 * 定义从用户表操作取得数据的各种方法
 * @author 
 *
 */
public interface UserDao {

	/**
	 * 根据用户名和密码查询返回一个用户的全部信息
	 * @param userName	用户名
	 * @param pwd	密码
	 * @return	对应的用户全部信息
	 */
	User queryUser(String userName,String pwd);
	
	/**
	 * 往用户表中插入一条数据
	 * @param user	一个user对象
	 */
	int insertOne(User user);
	
	/**
	 * 通过用户编号查询该用户
	 * @param u_id	用户编号
	 * @return	该用户
	 */
	User queryUserById(int u_id);
	
	//用户类型查询
	
	int queryUserType(String u_loginId,String u_loginPwd);
}

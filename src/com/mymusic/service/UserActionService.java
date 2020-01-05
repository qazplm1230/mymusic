package com.mymusic.service;

import java.util.List;


import com.mymusic.entity.HearSongHistory;
import com.mymusic.entity.User;
/**
 * 接口
 * 定义和用户有关的各种操作方法
 * @author 
 *
 */
public interface UserActionService {
	
	/**
	 * 根据（用户名，密码）查询返回一个用户的全部信息
	 * @param userName	用户名
	 * @param pwd	密码
	 * @return	对应的用户全部信息
	 */
	User queryUser(String userName,String pwd);
	
	/**
	 * 根据（用户名，密码，性别）创建一个新用户
	 * @param userName	用户名
	 * @param pwd	密码
	 * @param sex	性别
	 * @return
	 */
	int doRegister(String userName,String pwd,String sex);

	/**
	 * 获取用户的听歌历史
	 * @param u_id
	 * @return 
	 */
	public List<HearSongHistory> showHearSongHistory(int u_id);
	
	/**
	 * 根据歌曲id和歌单id，将该歌曲加入歌单
	 * @param sl_id
	 * @param s_id
	 * @return
	 */
	int addSongToSongList(String sl_id,String s_id);
	
	//用户类型查看
	
	int queryUserType(String u_loginId,String u_loginPwd);
}

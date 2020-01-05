package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.UserWithCd;
/**
 * 接口
 * 定义用户收藏专辑表的各种数据库操作方法
 * @author 
 *
 */
public interface UserWithCdDao {

	/**
	 * 通过用户编号查询用户专辑表的多条记录
	 * @param userId	用户编号
	 * @return	用户专辑表的多条记录
	 */
	List<UserWithCd> queryUserWithCds(int userId);
}

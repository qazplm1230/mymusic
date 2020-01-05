package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.UserWithSinger;

/**
 * 接口
 * 定义处理用户收藏歌手表的各种方法
 * @author 
 *
 */
public interface UserWithSingerDao {

	/**
	 * 通过用户编号查询收藏表中对应的多条记录
	 * @param userId 用户编号
	 * @return 多条记录
	 */
	List<UserWithSinger> queryUerWithSingers(int userId);
}

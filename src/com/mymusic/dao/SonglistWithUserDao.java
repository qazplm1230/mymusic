package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.SonglistWithUser;

/**
 * 接口
 * 用户收藏歌单表
 * @author 
 *
 */
public interface SonglistWithUserDao {

	/**
	 * 根据用户编号查询对应的多条收藏记录
	 * @param slwu_userId		用户编号
	 * @return		多条收藏记录
	 */
	List<SonglistWithUser> querySonglistWithUser(int slwu_userId);

	/**
	 * 根据歌单编号和用户编号删除一个收藏歌单记录
	 * @param slId	歌单编号
	 * @param u_id	用户编号
	 * @return
	 */
	int deleteOne(int slId, int u_id);
}

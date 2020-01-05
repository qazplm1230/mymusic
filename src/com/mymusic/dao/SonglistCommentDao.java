package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.SonglistComment;

/**
 * 歌单评论表
 * @author 
 *
 */
public interface SonglistCommentDao {

	/**
	 * 根据歌单编号查询对应的所有评论记录
	 * @param sl_id	歌单编号
	 * @return	所有评论记录
	 */
	List<SonglistComment> queryBySonglistId(int sl_id);
	
	/**
	 * 插入一条评论
	 * @param slComment	评论对象
	 * @return	受影响的行数
	 */
	int insertOneComment(SonglistComment slComment);
}

package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.SongComment;

/**
 * 歌曲评论表
 * @author 
 *
 */
public interface SongCommentDao {

	/**
	 * 根据歌曲编号查询所有的歌曲评论
	 * @param s_id
	 * @return
	 */
	List<SongComment> queryAllCommentsById(int s_id);
	
	/**
	 * 插入一条评论
	 * @param sComment	评论对象
	 * @return	受影响的行数
	 */
	int inserOneComment(SongComment sComment);
}

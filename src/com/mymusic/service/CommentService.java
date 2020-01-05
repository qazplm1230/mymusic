package com.mymusic.service;

import java.util.List;

import com.mymusic.entity.SongComment;
import com.mymusic.entity.SonglistComment;

/**
 * 接口
 * 处理所有和评论相关的业务
 * @author 
 *
 */
public interface CommentService {

	/**
	 * 显示所有关于该歌单的评论
	 * @param sl_id	歌单编号
	 * @return	所有评论集合
	 */
	List<SonglistComment> showAllSonglistComments(int sl_id);
	
	/**
	 * 显示所有关于该歌曲评论
	 * @param s_id	歌曲编号
	 * @return	所有评论集合
	 */
	List<SongComment> showAllSongComment(int s_id);
}

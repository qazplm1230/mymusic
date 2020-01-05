package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.Singer;

/**
 * 接口
 * 定义从歌手表中取得的各种数据方法
 * @author 
 */
public interface SingerDao {

	/**
	 * 通过收藏编号查询歌手表中对应被收藏的歌手信息并返回该歌手
	 * @param userId  收藏表中的歌手编号
	 * @return 被收藏的歌手信息
	 */
	Singer querySinger(int uws_SingerId);

	/**
	 * 根据歌名模糊查询到相应的歌手
	 * @param songName	歌名
	 * @return	相应的歌手
	 */
	List<Singer> querySinger(String singerName);
		
	/**
	 * 根据歌手id查出歌手 返回歌手表详细信息
	 * @param sg_id
	 * @return 当前歌手信息
	 */
	Singer showOneSinger(int sg_id);
	
	/**
	 * 根据歌曲的id找到歌手的全部信息
	 * @param s_id
	 * @return 当前歌手
	 */
	Singer findSinger(int sg_id);
}

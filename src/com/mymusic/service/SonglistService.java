package com.mymusic.service;

import java.util.List;

import com.mymusic.entity.Songlist;

/**
 * 接口
 * 处理和歌单的所有业务
 * @author 
 *
 */
public interface SonglistService {

	/**
	 * 获取收藏排名前十的歌单
	 * @return
	 */
	List<Songlist> showTopCollectionSonglist();
	
	/**
	 * 根据用户id查找用户歌单
	 * @param u_id
	 * @return 返回一个用户歌单集合
	 */
	List<Songlist> findUserSongList(String u_id);
	
	/**
	 * 根据歌单编号显示歌单详情
	 * @param sl_id		歌单编号
	 * @return	歌单的详细信息
	 */
	Songlist  showDetailSonglist(int sl_id);
	
	/**
	 * 创建一个新歌单
	 * @param songlist	歌单对象
	 * @return	受影响的行数
	 */
	int creatNewSonglist(Songlist songlist);

}

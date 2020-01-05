package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.SonglistWithSong;

/**
 * 接口
 * 歌单歌曲表
 * @author 
 *
 */
public interface SonglistWithSongDao {

	/**
	 * 根据歌单编号查询歌单歌曲表中对应的多条记录
	 * @param slws_songId 	歌单编号
	 * @return		多条记录集合
	 */
	List<SonglistWithSong> querySonglistWithSongs(int slws_songlistId);
	
	/**
	 * 根据歌曲id和歌单id，将该歌曲加入歌单
	 * @param sl_id
	 * @param s_id
	 * @return
	 */
	int addSongToSongList(int sl_id,int s_id);

	/**
	 * 根据歌曲编号和歌单编号，删除该条记录
	 * @param s_id	歌曲编号
	 * @param sl_id	歌单编号
	 * @return	受影响的行数
	 */
	int removeOne(int s_id, int sl_id);
}

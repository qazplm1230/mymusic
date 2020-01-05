package com.mymusic.dao;

import java.sql.SQLException;
import java.util.List;

import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
/**
 * 接口
 * 歌曲表
 * @author 
 *
 */
public interface SongDao {

	/**
	 * 根据歌曲编号查询对应的歌曲
	 * @param s_id		歌曲编号
	 * @return		一条歌曲
	 */
	Song querySong(int s_id);

	/**
	 * 查询所有歌曲
	 * @return
	 */
	List<Song> queryAllSongsorderByTime();

	/**
	 * 按照播放量查询所有的歌曲
	 * @return
	 */
	List<Song> queryAllSongsorderByPlay();

	/**
	 * 根据字符串模糊查询对应的歌曲
	 * @return	歌曲集合
	 */
	List<Song> querySongLikeString(String songName);
	
	/**
	 * 根据歌手的id  查询所有该歌手的歌曲
	 * @param sg_id
	 * @return  一个歌曲的集合
	 */
	List<Song> singerSongs(int sg_id);
	
	/**
	 * 根据歌曲的id找到当前歌曲的全部信息
	 * @param s_id
	 * @return 当前歌曲
	 */
	Song findSong(int s_id);
	
	/**
	 * 根据歌曲类型找到相似的歌曲
	 * @param s_type
	 * @return  相似歌曲集合
	 */
	List<Song> likeSongs(int s_type);
	
	/**
	 * 根据歌单id查找所有歌曲
	 * @param sl_id
	 * @return 用户第一个歌单的歌曲集合
	 */
	List<Song> findUserSongs(int sl_id);
	
	Song getById(int sid);
	List getByTypeId(int tid);
	Singer getSingerById(int sgid);
	List getSingersById(int sgid);
	
	/**
	 * 根据专辑编号，查询出所有的歌曲
	 * @param s_cdId	专辑编号
	 * @return	所有的歌曲
	 */
	List<Song> querySongsToCd(int s_cdId);
	
	//后台歌曲管理
	
	Song getSongById(int s_id)  throws SQLException;	
	
	int delSong(int s_id) throws SQLException;
	
	int addSong(Song obj) throws SQLException;
	
	long getCount()throws SQLException;
	
	List<Song> getPage(int page, int size) throws SQLException;
	
	int updateSong(Song obj) throws SQLException;
}

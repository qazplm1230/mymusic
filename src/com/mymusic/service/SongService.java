package com.mymusic.service;


import java.sql.SQLException;
import java.util.List;

import com.mymusic.entity.PageBean;
import com.mymusic.entity.User;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.Type;

/**
 * 接口
 * 处理和歌曲相关的业务
 * @author 
 *
 */
public interface SongService {
	
	/**
	 * 显示所有歌曲
	 * @return
	 */
	List<Song> showAllSongs();
	
	/**
	 * 按照播放次数显示所有歌曲显示
	 * @return
	 */
	List<Song> showAllSongsOrderByPlay();
	
	/**
	 * 根据异步请求的歌名返回到相应的歌曲
	 * @param songName	歌名
	 * @return	相应的歌曲
	 */
	List<Song> showAjaxSongs(String songName);
	
	/**
	 * 根据歌曲的id找到当前歌曲的全部信息
	 * @param s_id
	 * @return 当前歌曲
	 */
	Song findSong(String s_id);
	
	/**
	 * 根据歌曲表中的歌手id找到歌手的全部信息
	 * @param sg_id
	 * @return 当前歌手
	 */
	Singer findSinger(int sg_id);
	
	/**
	 * 根据歌曲表中的分类id找到歌手的全部信息
	 * @param t_id
	 * @return 当前类别
	 */
	Type findType(int t_id);
	
	/**
	 * 查找所有的歌曲类型
	 * @return  一个类别列表
	 */
	List<Type> finAllType();
	
	/**
	 * 根据歌曲类型找到相似的歌曲
	 * @param s_type
	 * @return  相似歌曲集合
	 */
	List<Song> findLikeSongs(int s_typeId);
	
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
	 * 根据用户id查找用户歌单
	 * @param u_id
	 * @return 返回一个用户歌单集合
	 */
	List<Songlist> findUserSongList(int u_id);
	
	//后台管理
	
	int addSong(String s_name,String s_singername,String sp[]);
	PageBean getPage(String page,int size);
	//User login(String uname,String upass);
	int delSong(String s_id);
	int updateSong(String s_id, String s_name, String s_singername, String sp[]) throws SQLException;
}

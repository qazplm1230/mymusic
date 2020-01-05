package com.mymusic.service;

import java.util.List;
import com.mymusic.entity.Area;
import com.mymusic.entity.Cd;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;

/**
 * 接口
 * 处理和歌手有关的业务
 * @author 
 *
 */
public interface SingerService {

	/**
	 * 根据异步请求的歌名返回到相应的歌手
	 * @param songName	歌名
	 * @return	相应的歌手
	 */
	List<Singer> showAjaxSingers(String singerName);
	
	/**
	 * 根据歌手id查出歌手 返回歌手表详细信息
	 * @param sg_id
	 * @return 当前歌手信息
	 */
	Singer showOneSinger(String sg_id);
	
	/**
	 * 根据歌手id查出地区 返回地区表详细信息
	 * @param sg_id
	 * @return 歌手的地区
	 */
	Area showOneArea(String sg_id);
	
	/**
	 * 根据歌手的id 查询对应歌手的专辑
	 * @param sg_id
	 * @return 一个专辑集合
	 */
	List<Cd> singerCds(String sg_id);

	/**
	 * 根据歌手id查询对应歌手的歌曲
	 * @param sg_id
	 * @return 一个歌曲集合
	 */
	List<Song> singerSongs(String sg_id);
}

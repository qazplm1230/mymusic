package com.mymusic.service.Impl;

import java.util.List;
import com.mymusic.dao.AreaDao;
import com.mymusic.dao.CdDao;
import com.mymusic.dao.SingerDao;
import com.mymusic.dao.SongDao;
import com.mymusic.dao.Impl.AreaDaoImpl;
import com.mymusic.dao.Impl.CdDaoImpl;
import com.mymusic.dao.Impl.SingerDaoImpl;
import com.mymusic.dao.Impl.SongDaoImpl;
import com.mymusic.entity.Area;
import com.mymusic.entity.Cd;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.service.SingerService;
/**
 * 实现类
 * 处理和歌手有关的所有业务
 * @author 
 *
 */
public class SingerServiceImpl implements SingerService{
	
	//声明SingerDao
	private SingerDao singerDao = new SingerDaoImpl();
	private AreaDao adao = new AreaDaoImpl();
	private CdDao cdao = new CdDaoImpl();
	private SongDao sdao = new SongDaoImpl();

	/**
	 * 根据异步请求的歌名返回到相应的歌手
	 * @param songName	歌名
	 * @return	相应的歌手
	 */
	@Override
	public List<Singer> showAjaxSingers(String singerName) {
		return singerDao.querySinger(singerName);
		
	}


	/**
	 * 判断传入的值是否为空
	 * @param 字符型 sg_id
	 * @return 整数型 id
	 */
	private static int Check(String sg_id){
		int id=0;
		if (sg_id==null&&sg_id=="") {
			id=1;
		}else{
			id=Integer.parseInt(sg_id);
		}
		return id;
	}
	/**
	 * 根据歌手id查出歌手 返回歌手表详细信息
	 * @param sg_id
	 * @return 当前歌手信息
	 */
	@Override
	public Singer showOneSinger(String sg_id) {
		int id = Check(sg_id);
		Singer singer = singerDao.showOneSinger(id);
		return singer;
	}

	/**
	 * 根据歌手id查出地区 返回地区表详细信息
	 * @param sg_id
	 * @return 歌手的地区
	 */
	@Override
	public Area showOneArea(String sg_id) {
		int id = Check(sg_id);
		Area area = adao.findArea(id);
		return area;
	}

	/**
	 * 根据歌手的id 查询对应歌手的专辑
	 * @param sg_id
	 * @return 一个专辑集合
	 */
	@Override
	public List<Cd> singerCds(String sg_id) {
		int id = Check(sg_id);
		List<Cd> cds = cdao.singerCds(id);
		return cds;
	}

	/**
	 * 根据歌手id查询对应歌手的歌曲
	 * @param sg_id
	 * @return 一个歌曲集合
	 */
	@Override
	public List<Song> singerSongs(String sg_id) {
		int id = Check(sg_id);
		List<Song> songs = sdao.singerSongs(id);
		return songs;
	}

}

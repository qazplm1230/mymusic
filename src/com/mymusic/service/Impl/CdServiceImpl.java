package com.mymusic.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.mymusic.dao.CdDao;
import com.mymusic.dao.SingerDao;
import com.mymusic.dao.SongDao;
import com.mymusic.dao.Impl.CdDaoImpl;
import com.mymusic.dao.Impl.SingerDaoImpl;
import com.mymusic.dao.Impl.SongDaoImpl;
import com.mymusic.entity.Cd;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.service.CdService;
/**
 * 实现类
 * 处理和专辑有关的所有业务
 * @author 
 *
 */
public class CdServiceImpl implements CdService{

	//声明CdDao
	private CdDao cdDao = new CdDaoImpl();
	//声明SingerDao
	private SingerDao singerDao = new SingerDaoImpl();
	//声明songDao
	private SongDao songDao = new SongDaoImpl();
	
	
	
	/**
	 * 查询出所有的专辑
	 */
	@Override
	public List<Cd> showAllCds() {
		List<Cd> cds = new ArrayList<>();
		cds = cdDao.queryAllCds();
		Singer singer = null;
		for (Cd cd : cds) {
			singer = singerDao.querySinger(cd.getC_singerId());
			cd.setSinger(singer);
		}
		return cds;
	}
	
	/**
	 * 显示专辑详情信息
	 */
	@Override
	public Cd getById(int cid) {
		Cd cd=cdDao.getById(cid);
		List<Song> songs = songDao.querySongsToCd(cd.getC_id());
		cd.setSongs(songs);
		cd.setSinger(singerDao.showOneSinger(cd.getC_singerId()));
		return cd;
	}

	@Override
	public List<Cd> getCDs() {
		List<Cd> cdls=cdDao.getCDs();
		for (Cd cd : cdls) {
			cd.setSinger(singerDao.showOneSinger(cd.getC_singerId()));
		}
		return cdls;
	}

	/**
	 * 显示最新的专辑
	 * @return
	 */
	@Override
	public List<Cd> showNewCds() {
		List<Cd> cds = cdDao.queryNewCds();
		for (Cd cd : cds) {
			cd.setSinger(singerDao.showOneSinger(cd.getC_singerId()));
		}
		return cds;
	}

	/**
	 * 根据歌手编号显示相似的专辑
	 * @param sg_id		歌手编号
	 * @return	这个歌手的其他专辑
	 */
	@Override
	public List<Cd> showSameCds(int sg_id) {
		return cdDao.singerCds(sg_id);
	}

}

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
 * ʵ����
 * �����ר���йص�����ҵ��
 * @author 
 *
 */
public class CdServiceImpl implements CdService{

	//����CdDao
	private CdDao cdDao = new CdDaoImpl();
	//����SingerDao
	private SingerDao singerDao = new SingerDaoImpl();
	//����songDao
	private SongDao songDao = new SongDaoImpl();
	
	
	
	/**
	 * ��ѯ�����е�ר��
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
	 * ��ʾר��������Ϣ
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
	 * ��ʾ���µ�ר��
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
	 * ���ݸ��ֱ����ʾ���Ƶ�ר��
	 * @param sg_id		���ֱ��
	 * @return	������ֵ�����ר��
	 */
	@Override
	public List<Cd> showSameCds(int sg_id) {
		return cdDao.singerCds(sg_id);
	}

}

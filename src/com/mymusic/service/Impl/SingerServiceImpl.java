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
 * ʵ����
 * ����͸����йص�����ҵ��
 * @author 
 *
 */
public class SingerServiceImpl implements SingerService{
	
	//����SingerDao
	private SingerDao singerDao = new SingerDaoImpl();
	private AreaDao adao = new AreaDaoImpl();
	private CdDao cdao = new CdDaoImpl();
	private SongDao sdao = new SongDaoImpl();

	/**
	 * �����첽����ĸ������ص���Ӧ�ĸ���
	 * @param songName	����
	 * @return	��Ӧ�ĸ���
	 */
	@Override
	public List<Singer> showAjaxSingers(String singerName) {
		return singerDao.querySinger(singerName);
		
	}


	/**
	 * �жϴ����ֵ�Ƿ�Ϊ��
	 * @param �ַ��� sg_id
	 * @return ������ id
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
	 * ���ݸ���id������� ���ظ��ֱ���ϸ��Ϣ
	 * @param sg_id
	 * @return ��ǰ������Ϣ
	 */
	@Override
	public Singer showOneSinger(String sg_id) {
		int id = Check(sg_id);
		Singer singer = singerDao.showOneSinger(id);
		return singer;
	}

	/**
	 * ���ݸ���id������� ���ص�������ϸ��Ϣ
	 * @param sg_id
	 * @return ���ֵĵ���
	 */
	@Override
	public Area showOneArea(String sg_id) {
		int id = Check(sg_id);
		Area area = adao.findArea(id);
		return area;
	}

	/**
	 * ���ݸ��ֵ�id ��ѯ��Ӧ���ֵ�ר��
	 * @param sg_id
	 * @return һ��ר������
	 */
	@Override
	public List<Cd> singerCds(String sg_id) {
		int id = Check(sg_id);
		List<Cd> cds = cdao.singerCds(id);
		return cds;
	}

	/**
	 * ���ݸ���id��ѯ��Ӧ���ֵĸ���
	 * @param sg_id
	 * @return һ����������
	 */
	@Override
	public List<Song> singerSongs(String sg_id) {
		int id = Check(sg_id);
		List<Song> songs = sdao.singerSongs(id);
		return songs;
	}

}

package com.mymusic.service.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.SongDao;
import com.mymusic.dao.SonglistDao;
import com.mymusic.dao.SonglistWithSongDao;
import com.mymusic.dao.UserDao;
import com.mymusic.dao.Impl.SongDaoImpl;
import com.mymusic.dao.Impl.SonglistDaoImpl;
import com.mymusic.dao.Impl.SonglistWithSongDaoImpl;
import com.mymusic.dao.Impl.UserDaoImpl;
import com.mymusic.entity.Song;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.SonglistWithSong;
import com.mymusic.entity.User;
import com.mymusic.service.SonglistService;
import com.mymusic.util.DBUtil;
/**
 * ʵ����
 * ����͸赥������ҵ��
 * @author 
 *
 */
public class SonglistServiceImpl implements SonglistService{
	
	//����SonglistDao
	private SonglistDao songlistDao = new SonglistDaoImpl();
	//����SongDao
	private SongDao songDao = new SongDaoImpl();
	//����SonglistWithSong
	private SonglistWithSongDao slws = new SonglistWithSongDaoImpl();
	//����UserDao
	private UserDao userDao = new UserDaoImpl();

	/**
	 * �жϴ����ֵ�Ƿ�Ϊ��
	 * @param �ַ��� sg_id
	 * @return ������ id
	 */
	private static int Check(String u_id){
		int id=0;
		if (u_id==null&&u_id=="") {
			id=1;
		}else{
			id=Integer.parseInt(u_id);
		}
		return id;
	}
	
	/**
	 * �����û�id�����û��赥
	 * @param u_id
	 * @return ����һ���û��赥����
	 */
	@Override
	public List<Songlist> findUserSongList(String u_id) {
		int id = Check(u_id);
		List<Songlist> userSonglists = songlistDao.findUserSongList(id);
		return userSonglists;
	}

	/**
	 * ��ȡ�ղ�����ǰʮ�ĸ赥
	 * @return
	 */
	@Override
	public List<Songlist> showTopCollectionSonglist() {
		List<Songlist> songlists = new ArrayList<>();
		songlists = songlistDao.queryAllSonglistOrderByCol();
		return songlists;
		
	}

	/**
	 * ���ݸ赥�����ʾ�赥����
	 * @param sl_id		�赥���
	 * @return	�赥����ϸ��Ϣ
	 */
	@Override
	public Songlist showDetailSonglist(int sl_id) {
		Songlist songlist = songlistDao.querySonglistsById(sl_id);
		//��Ӹø赥�����ĸ���
		List<SonglistWithSong> slwsSongs = slws.querySonglistWithSongs(songlist.getSl_id());
		List<Song> songs = new ArrayList<>();
		Song song = null;
		for (SonglistWithSong songlistWithSong : slwsSongs) {
			song = songDao.querySong(songlistWithSong.getSlws_songId());
			
			songs.add(song);
		}
		songlist.setSongs(songs);
		//��Ӵ����ø赥���û�
		songlist.setUser(userDao.queryUserById(songlist.getSl_userId()));
		
		return songlist;
	}

	/**
	 * ����һ���¸赥
	 * @param songlist	�赥����
	 * @return	��Ӱ�������
	 */
	@Override
	public int creatNewSonglist(Songlist songlist) {
		//�ж��Ƿ����ͬ���赥
		Songlist slist = songlistDao.querySonglistsByName(songlist.getSl_name());
		if (slist == null) {
			return songlistDao.createOneSonglist(songlist);
		}else {
			return 0;
		}
	}

	
}

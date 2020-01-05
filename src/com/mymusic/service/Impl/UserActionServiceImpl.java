package com.mymusic.service.Impl;

import java.util.ArrayList;
import java.util.List;


import com.mymusic.dao.CdDao;
import com.mymusic.dao.HearSongHistoryDao;
import com.mymusic.dao.SingerDao;
import com.mymusic.dao.SongDao;
import com.mymusic.dao.SonglistDao;
import com.mymusic.dao.SonglistWithSongDao;
import com.mymusic.dao.SonglistWithUserDao;
import com.mymusic.dao.UserDao;
import com.mymusic.dao.UserWithCdDao;
import com.mymusic.dao.UserWithSingerDao;
import com.mymusic.dao.Impl.CdDaoImpl;
import com.mymusic.dao.Impl.HearSongHistoryDaoImpl;
import com.mymusic.dao.Impl.SingerDaoImpl;
import com.mymusic.dao.Impl.SongDaoImpl;
import com.mymusic.dao.Impl.SonglistDaoImpl;
import com.mymusic.dao.Impl.SonglistWithSongDaoImpl;
import com.mymusic.dao.Impl.SonglistWithUserDaoImpl;
import com.mymusic.dao.Impl.UserDaoImpl;
import com.mymusic.dao.Impl.UserWithCdDaoImpl;
import com.mymusic.dao.Impl.UserWithSingerDaoImpl;
import com.mymusic.entity.Cd;
import com.mymusic.entity.HearSongHistory;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.SonglistWithSong;
import com.mymusic.entity.SonglistWithUser;
import com.mymusic.entity.User;
import com.mymusic.entity.UserWithCd;
import com.mymusic.entity.UserWithSinger;
import com.mymusic.service.UserActionService;

/**
 * ʵ����   ʵ�ֺ��û��йصĸ���ҵ�񷽷�
 * @author 
 * 
 */
public class UserActionServiceImpl implements UserActionService {

	// ����һ��UserDao����
	private UserDao userDao = new UserDaoImpl();
	//����һ��SingerDao����
	private SingerDao singerDao = new SingerDaoImpl();
	//����һ��UserWithSingerDao����
	private UserWithSingerDao userSingerDao = new UserWithSingerDaoImpl();
	//����һ��UserWithCdDao����
	private UserWithCdDao userCdDao = new UserWithCdDaoImpl();
	//����һ��CdDao����
	private CdDao cdDao = new CdDaoImpl();
	//����һ��SonglistDao����
	private SonglistDao songlistDao = new SonglistDaoImpl();
	//����һ��SonglistWithSongDao����
	private SonglistWithSongDao songlistWithSongDao = new SonglistWithSongDaoImpl();
	//����һ��SongDao����
	private SongDao songDao = new SongDaoImpl();
	//����һ��HearSongHistoryDao
	private HearSongHistoryDao hearSongHistoryDao = new HearSongHistoryDaoImpl();
	//����һ��SonglistWithUserDao����
	private SonglistWithUserDao songlistWithUserDao = new SonglistWithUserDaoImpl();
	
	
	/**
	 * ���ݣ��û��������룩��ѯ����һ���û���ȫ����Ϣ(�����ղصĸ��֡��ղصĸ赥�������¼�������ĸ赥)
	 * @param userName 	�û���
	 * @param pwd	����
	 * @return ��Ӧ���û�ȫ����Ϣ
	 */
	@Override
	public User queryUser(String userName, String pwd) {
		User user = userDao.queryUser(userName, pwd);
		//�ж��Ƿ�������û���û��ֱ���˳�������������Ĳ���
		if (user==null) {
			return null;
		}
		
		//��ȡ�û��ղصĸ���
		List<Singer> singers = new ArrayList<>();
		//1�����û���Ŵ��ղر��л�ȡ�ղؼ�¼����
		List<UserWithSinger> list = userSingerDao.queryUerWithSingers(user.getU_id());
		//2�����ղؼ�¼����
		Singer singer = null;
		for (UserWithSinger userWithSinger : list) {
			//���ݸ��ֱ�ŴӸ��ֱ��л�ȡ������Ϣ
			singer = singerDao.querySinger(userWithSinger.getUws_singerId());
			singers.add(singer);
		}
		user.setCollectionSgs(singers);
		
		//��ȡ�û��ղص�ר��
		List<Cd> cds = new ArrayList<>();
		List<UserWithCd> list2 = userCdDao.queryUserWithCds(user.getU_id());
		Cd cd = null;
		for (UserWithCd userCd : list2) {
			cd = cdDao.queryCd(userCd.getUwc_cdId());
			cds.add(cd);
		}
		user.setCollectionCds(cds);
		
		//��ȡ�û������ĸ赥
		List<Songlist> list3 = new ArrayList<>();
		List<SonglistWithSong> list4 = new ArrayList<>();
		list3 = songlistDao.querySonglistsByUserId(user.getU_id());
		List<Song> songs = new ArrayList<>();
		Song song = null;
		for (Songlist songlist : list3) {
			list4 = songlistWithSongDao.querySonglistWithSongs(songlist.getSl_id());
			for (SonglistWithSong songlistWithSong : list4) {
				song  = songDao.querySong(songlistWithSong.getSlws_songId());
				songs.add(song);
			}
			songlist.setSongs(songs);
		}
		user.setCreateSonglists(list3);
		
		
		//��ȡ�û���������ʷ��¼����
		List<HearSongHistory> list5 = showHearSongHistory(user.getU_id());
		user.setHeardSongs(list5);
		
		//�û��ղصĸ赥
		List<Songlist> list6 = new ArrayList<>();
		List<SonglistWithUser> list7 = new ArrayList<>();
		list7 = songlistWithUserDao.querySonglistWithUser(user.getU_id());
		Songlist songlist = null;
		for (SonglistWithUser songlistWithUser : list7) {
			songlist = songlistDao.querySonglistsById(songlistWithUser.getSlwu_songlistId());
			list6.add(songlist);
		}
		user.setCollectionSonglists(list6);
		
		//����������ݵ�user����
		return user;
	}

	/**
	 * ��ȡ�û���������ʷ
	 * @param u_id
	 * @return 
	 */
	@Override
	public List<HearSongHistory> showHearSongHistory(int u_id) {
		Song song = null;
		List<HearSongHistory> list = hearSongHistoryDao.queryHearSongHistories(u_id);
		for (HearSongHistory hearSongHistory : list) {
			song = songDao.querySong(hearSongHistory.getHsh_songId());
			hearSongHistory.setSong(song);
		}
		return list;
		
	}


	/**
	 * ���ݣ��û��������룬�Ա𣩴���һ�����û�
	 * @param userName	�û���
	 * @param pwd	����
	 * @param sex	�Ա�
	 * @return
	 */
	@Override
	public int doRegister(String userName, String pwd, String sex) {
		User tempUser = userDao.queryUser(userName, pwd);
		if (tempUser!=null) {
			return 0;
		}else {
			int userSex = Integer.parseInt(sex);
			//�����Ա��Ĭ�ϵ�ͷ��
			String photoPath = null;
			String sexString = "��";
			if (userSex==0) {
				sexString = "Ů";
				photoPath = "resource/u_images/default-girl.png"; 
			}else {
				photoPath = "resource/u_images/default-boy.png"; 
			}
			User user = new User(userName, pwd, userName,sexString, photoPath, 0);
			//���û������һ������
			userDao.insertOne(user);
			user = userDao.queryUser(userName, pwd);
			
			
			if (user!=null) {
				//����һ��Ĭ�ϵĸ赥
				Songlist songlist = new Songlist(user.getU_id(), "��ϲ��������", 0, 0, "resource/sl_images/default.PNG", 0);
				int result = songlistDao.insertOne(songlist);
				return result;
			}else {
				return 0;
			}
		}
	}
	
	/**
	 * ���ݸ���id�͸赥id�����ø�������赥
	 * @param sl_id
	 * @param s_id
	 * @return
	 */
	@Override
	public int addSongToSongList(String sl_id, String s_id) {
		int s_id1 = Check(s_id);
		int sl_id1 = Check(sl_id);
		int result = 0;
		result = songlistWithSongDao.addSongToSongList(sl_id1,s_id1);
		return result;
	}
	
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
	
	//�鿴�û�����
	@Override
	public int queryUserType(String u_loginId, String u_loginPwd) {
		int n=0;
		n=userDao.queryUserType(u_loginId, u_loginPwd);
		
		return n;
	}

	
}

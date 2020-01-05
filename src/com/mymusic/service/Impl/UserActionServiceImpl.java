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
 * 实现类   实现和用户有关的各种业务方法
 * @author 
 * 
 */
public class UserActionServiceImpl implements UserActionService {

	// 声明一个UserDao对象
	private UserDao userDao = new UserDaoImpl();
	//声明一个SingerDao对象
	private SingerDao singerDao = new SingerDaoImpl();
	//声明一个UserWithSingerDao对象
	private UserWithSingerDao userSingerDao = new UserWithSingerDaoImpl();
	//声明一个UserWithCdDao对象
	private UserWithCdDao userCdDao = new UserWithCdDaoImpl();
	//声明一个CdDao对象
	private CdDao cdDao = new CdDaoImpl();
	//声明一个SonglistDao对象
	private SonglistDao songlistDao = new SonglistDaoImpl();
	//声明一个SonglistWithSongDao对象
	private SonglistWithSongDao songlistWithSongDao = new SonglistWithSongDaoImpl();
	//声明一个SongDao对象
	private SongDao songDao = new SongDaoImpl();
	//声明一个HearSongHistoryDao
	private HearSongHistoryDao hearSongHistoryDao = new HearSongHistoryDaoImpl();
	//声明一个SonglistWithUserDao对象
	private SonglistWithUserDao songlistWithUserDao = new SonglistWithUserDaoImpl();
	
	
	/**
	 * 根据（用户名，密码）查询返回一个用户的全部信息(包括收藏的歌手、收藏的歌单、听歌记录、创建的歌单)
	 * @param userName 	用户名
	 * @param pwd	密码
	 * @return 对应的用户全部信息
	 */
	@Override
	public User queryUser(String userName, String pwd) {
		User user = userDao.queryUser(userName, pwd);
		//判断是否有这个用户，没有直接退出，不进行下面的操作
		if (user==null) {
			return null;
		}
		
		//获取用户收藏的歌手
		List<Singer> singers = new ArrayList<>();
		//1根据用户编号从收藏表中获取收藏记录集合
		List<UserWithSinger> list = userSingerDao.queryUerWithSingers(user.getU_id());
		//2遍历收藏记录集合
		Singer singer = null;
		for (UserWithSinger userWithSinger : list) {
			//根据歌手编号从歌手表中获取歌手信息
			singer = singerDao.querySinger(userWithSinger.getUws_singerId());
			singers.add(singer);
		}
		user.setCollectionSgs(singers);
		
		//获取用户收藏的专辑
		List<Cd> cds = new ArrayList<>();
		List<UserWithCd> list2 = userCdDao.queryUserWithCds(user.getU_id());
		Cd cd = null;
		for (UserWithCd userCd : list2) {
			cd = cdDao.queryCd(userCd.getUwc_cdId());
			cds.add(cd);
		}
		user.setCollectionCds(cds);
		
		//获取用户创建的歌单
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
		
		
		//获取用户的听歌历史记录集合
		List<HearSongHistory> list5 = showHearSongHistory(user.getU_id());
		user.setHeardSongs(list5);
		
		//用户收藏的歌单
		List<Songlist> list6 = new ArrayList<>();
		List<SonglistWithUser> list7 = new ArrayList<>();
		list7 = songlistWithUserDao.querySonglistWithUser(user.getU_id());
		Songlist songlist = null;
		for (SonglistWithUser songlistWithUser : list7) {
			songlist = songlistDao.querySonglistsById(songlistWithUser.getSlwu_songlistId());
			list6.add(songlist);
		}
		user.setCollectionSonglists(list6);
		
		//返回填好数据的user对象
		return user;
	}

	/**
	 * 获取用户的听歌历史
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
	 * 根据（用户名，密码，性别）创建一个新用户
	 * @param userName	用户名
	 * @param pwd	密码
	 * @param sex	性别
	 * @return
	 */
	@Override
	public int doRegister(String userName, String pwd, String sex) {
		User tempUser = userDao.queryUser(userName, pwd);
		if (tempUser!=null) {
			return 0;
		}else {
			int userSex = Integer.parseInt(sex);
			//根据性别给默认的头像
			String photoPath = null;
			String sexString = "男";
			if (userSex==0) {
				sexString = "女";
				photoPath = "resource/u_images/default-girl.png"; 
			}else {
				photoPath = "resource/u_images/default-boy.png"; 
			}
			User user = new User(userName, pwd, userName,sexString, photoPath, 0);
			//往用户表插入一条数据
			userDao.insertOne(user);
			user = userDao.queryUser(userName, pwd);
			
			
			if (user!=null) {
				//创建一个默认的歌单
				Songlist songlist = new Songlist(user.getU_id(), "我喜欢的音乐", 0, 0, "resource/sl_images/default.PNG", 0);
				int result = songlistDao.insertOne(songlist);
				return result;
			}else {
				return 0;
			}
		}
	}
	
	/**
	 * 根据歌曲id和歌单id，将该歌曲加入歌单
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
	 * 判断传入的值是否为空
	 * @param 字符型 sg_id
	 * @return 整数型 id
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
	
	//查看用户类型
	@Override
	public int queryUserType(String u_loginId, String u_loginPwd) {
		int n=0;
		n=userDao.queryUserType(u_loginId, u_loginPwd);
		
		return n;
	}

	
}

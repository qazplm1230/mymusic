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
 * 实现类
 * 处理和歌单的所有业务
 * @author 
 *
 */
public class SonglistServiceImpl implements SonglistService{
	
	//声明SonglistDao
	private SonglistDao songlistDao = new SonglistDaoImpl();
	//声明SongDao
	private SongDao songDao = new SongDaoImpl();
	//声明SonglistWithSong
	private SonglistWithSongDao slws = new SonglistWithSongDaoImpl();
	//声明UserDao
	private UserDao userDao = new UserDaoImpl();

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
	
	/**
	 * 根据用户id查找用户歌单
	 * @param u_id
	 * @return 返回一个用户歌单集合
	 */
	@Override
	public List<Songlist> findUserSongList(String u_id) {
		int id = Check(u_id);
		List<Songlist> userSonglists = songlistDao.findUserSongList(id);
		return userSonglists;
	}

	/**
	 * 获取收藏排名前十的歌单
	 * @return
	 */
	@Override
	public List<Songlist> showTopCollectionSonglist() {
		List<Songlist> songlists = new ArrayList<>();
		songlists = songlistDao.queryAllSonglistOrderByCol();
		return songlists;
		
	}

	/**
	 * 根据歌单编号显示歌单详情
	 * @param sl_id		歌单编号
	 * @return	歌单的详细信息
	 */
	@Override
	public Songlist showDetailSonglist(int sl_id) {
		Songlist songlist = songlistDao.querySonglistsById(sl_id);
		//添加该歌单包含的歌曲
		List<SonglistWithSong> slwsSongs = slws.querySonglistWithSongs(songlist.getSl_id());
		List<Song> songs = new ArrayList<>();
		Song song = null;
		for (SonglistWithSong songlistWithSong : slwsSongs) {
			song = songDao.querySong(songlistWithSong.getSlws_songId());
			
			songs.add(song);
		}
		songlist.setSongs(songs);
		//添加创建该歌单的用户
		songlist.setUser(userDao.queryUserById(songlist.getSl_userId()));
		
		return songlist;
	}

	/**
	 * 创建一个新歌单
	 * @param songlist	歌单对象
	 * @return	受影响的行数
	 */
	@Override
	public int creatNewSonglist(Songlist songlist) {
		//判断是否存在同名歌单
		Songlist slist = songlistDao.querySonglistsByName(songlist.getSl_name());
		if (slist == null) {
			return songlistDao.createOneSonglist(songlist);
		}else {
			return 0;
		}
	}

	
}

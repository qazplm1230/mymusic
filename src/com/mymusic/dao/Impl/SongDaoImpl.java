package com.mymusic.dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.mymusic.dao.SongDao;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.util.DBUtil;
	/**
	 *实现类
	 *实现歌曲表的各种操作
	 * @author 
	 *
	 */
public class SongDaoImpl implements SongDao{

	/**
	 * 根据歌曲表的歌曲编号查询对应的歌曲信息
	 * @param s_id	歌曲编号
	 * @return		歌曲信息
	 */
	@Override
	public Song querySong(int s_id) {
		String sql = "select * from song where s_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Song song = null;
		try {
			song = (Song) runner.query(sql, new BeanHandler(Song.class), s_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return song;
	}

	/**
	 * 按发行时间降序查询出所有的歌曲
	 * @param s_publishDate	发行时间
	 * @return 所有歌曲
	 */
	@Override
	public List<Song> queryAllSongsorderByTime() {
		String sql = "select * from song order by s_publishDate desc";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Song> songs = new ArrayList<>();
		try {
			songs = (List<Song>) runner.query(sql, new BeanListHandler(Song.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songs;
	}

	/**
	  * 按播放量降序查询出所有的歌曲
	 * @param s_playCount	歌曲播放量
	 * @return 所有歌曲
	 */
	@Override
	public List<Song> queryAllSongsorderByPlay() {
		String sql = "select * from song order by s_playCount desc";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Song> songs = new ArrayList<>();
		try {
			songs = (List<Song>) runner.query(sql, new BeanListHandler(Song.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songs;
	}

	/**
	 *按歌曲名字模糊查询搜索歌曲
	 * @return 	相关歌曲
	 */
	@Override
	public List<Song> querySongLikeString(String songName) {
		String sql = "select * from song where s_name like ? ";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Song> songs = new ArrayList<>();
		try {
			songs = runner.query(sql, new BeanListHandler<>(Song.class),"%"+songName+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songs;
	}
	
	/**
	 * 按歌手编号查询该歌手所有的歌曲
	 * @param sg_id
	 * @return  该歌手所有的歌曲
	 */
	@Override
	public List<Song> singerSongs(int sg_id) {
		String sql = "select * from song where s_singerId=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		List<Song> songs = null;
		try {
			songs = qr.query(sql, new BeanListHandler<Song>(Song.class),sg_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songs;
	}

	/**
	 * 按歌曲编号查询歌曲
	 * @param s_id
	 * @return 歌曲
	 */
	@Override
	public Song findSong(int s_id) {
		String sql = "select * from song where s_id=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		Song song = null;
		try {
			song = qr.query(sql, new BeanHandler<Song>(Song.class),s_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return song;
	}

	/**
	 *按歌曲类型编号查询该类型所有歌曲
	 * @param s_type
	 * @return  该类型所有歌曲
	 */
	@Override
	public List<Song> likeSongs(int s_typeId) {
		String sql = "select * from song where s_typeId=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		List<Song> songs = null;
		try {
			songs = qr.query(sql, new BeanListHandler<Song>(Song.class),s_typeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songs;
	}

	/**
	 * 根据歌单编号在歌单列表中查询歌单歌曲编号，根据歌单歌曲编号在歌曲表中查询歌曲编号
	 * @param sl_id
	 * @return 歌单中的歌曲
	 */
	@Override
	public List<Song> findUserSongs(int sl_id) {
		String sql = "select * from song where s_id in (select slws_songId from songlistwithsong where slws_songlistId=?)";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		List<Song> songs = null;
		try {
			songs = qr.query(sql, new BeanListHandler<Song>(Song.class),sl_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songs;
	}
	
	@Override
	public Song getById(int sid) {
		String sql ="select* from song where s_id=?";    
		QueryRunner run =new QueryRunner(DBUtil.ds); 
		Object params[]= {sid};
		Song song = null;
		try {
			song = (Song) run.query(sql,new BeanHandler(Song.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                	
		return song;
	}

	@Override
	public List getByTypeId(int tid) {
		String sql ="select* from song where s_typeid=? ";    
		QueryRunner run =new QueryRunner(DBUtil.ds);     
		Object params[]= {tid};
		List ls = null;	
		try {
			ls = (List) run.query(sql,new BeanListHandler(Song.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}                	
		return ls;
	}

	@Override
	public Singer getSingerById(int sgid) {
		String sql ="select* from singer where sg_id=?";    
		QueryRunner run =new QueryRunner(DBUtil.ds); 
		Object params[]= {sgid};
		Singer singer = null;
		try {
			singer = (Singer) run.query(sql,new BeanHandler(Singer.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                	
		return singer;
	}

	@Override
	public List getSingersById(int sgid) {
		String sql ="select* from singer where sg_id=? ";    
		QueryRunner run =new QueryRunner(DBUtil.ds);     
		Object params[]= {sgid};
		List ls = null;	
		try {
			ls = (List) run.query(sql,new BeanListHandler(Singer.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}                	
		return ls;
	}

	/**
	 * 根据专辑编号查询该专辑所有歌曲
	 * @param s_cdId	专辑编号
	 * @return	该专辑所有歌曲
	 */
	@Override
	public List<Song> querySongsToCd(int s_cdId) {
		String sql = "select * from song where s_cdId=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Song> songs = new ArrayList<>();
		try {
			songs = (List<Song>) runner.query(sql, new BeanListHandler(Song.class), s_cdId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songs;
	}
	
	
	
	
	
	//后台歌曲管理
	
	@Override
	public int addSong(Song obj) throws SQLException {
		String sql="insert into song(s_name,s_singername,s_languageType) values(?,?,?)";
		Object param[]= {obj.getS_name(),obj.getS_singername(),obj.getS_languageType()};
		Connection conn =DBUtil.getConnection();
		QueryRunner run=new QueryRunner();
		int n=run.update(conn,sql,param);
		conn.close();
		return n;
	}

	@Override
	public List<Song>getPage(int page,int size)throws SQLException{
		String sql="select * from song limit ?,?";
		Connection conn =DBUtil.getConnection();
		QueryRunner run=new QueryRunner();
		List list=(List) run.query( conn,sql,new BeanListHandler(Song.class),(page-1)*size,size);
		conn.close();
		return list;
	}
	

	@Override
	public long getCount() throws SQLException {
		String sql="select count(*)from song";	
		Connection conn =DBUtil.getConnection();
		QueryRunner run=new QueryRunner();
		Long n=(Long) run.query(conn,sql,new ScalarHandler());
		conn.close();
		return n;	
	}

	@Override
	public Song getSongById(int s_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delSong(int s_id) throws SQLException {
		String sql ="delete from song where s_id=?"; 
		Connection conn =DBUtil.getConnection();   
		QueryRunner run =new QueryRunner();         
		int n=run.update(conn,sql,s_id);         //QueryRunner的update(),有三个参数conn,sql,s_id         
		conn.close();
		return n;
		
	}

	@Override
	public int updateSong(Song obj) throws SQLException {
		
		String sql="update song set s_name=?,s_singername=?,s_languageType=?where s_id=?";
		Object[] params={obj.getS_name(),obj.getS_singername(),obj.getS_languageType(),obj.getS_id()  };
		Connection conn =DBUtil.getConnection();
		QueryRunner run=new QueryRunner();
		int n=run.update( conn,sql, params);
		conn.close();
		return n;
	}
	
}

package com.mymusic.dao.Impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.SonglistWithSongDao;
import com.mymusic.entity.SonglistWithSong;
import com.mymusic.util.DBUtil;
/**
 * 实现类
 * 歌单歌曲表
 * @author
 *
 */
public class SonglistWithSongDaoImpl implements SonglistWithSongDao{

	/**
	 * 根据歌单编号查询歌单歌曲表中对应的多条记录
	 * @param slws_songId 	歌单编号
	 * @return		查询到的多条记录集合
	 */
	public List<SonglistWithSong> querySonglistWithSongs(int slws_songlistId){
		String sql = "select * from songlistwithsong where slws_songlistId=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<SonglistWithSong> list = new ArrayList<>();
		try {
			list = (List<SonglistWithSong>) runner.query(sql, new BeanListHandler(SonglistWithSong.class), slws_songlistId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据歌曲id和歌单id，将该歌曲加入歌单
	 * @param sl_id
	 * @param s_id
	 * @return
	 */
	@Override
	public int addSongToSongList(int sl_id, int s_id) {
		String sql = "insert into songlistwithsong (slws_songlistId,slws_songId,slws_collectionDate) VALUES(?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Date time= new java.sql.Date(new java.util.Date().getTime());
		int result = 0;
		try {
			result = runner.execute(sql, sl_id,s_id,time);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据歌曲编号和歌单编号，删除该条记录
	 * @param s_id	歌曲编号
	 * @param sl_id	歌单编号
	 * @return	受影响的行数
	 */
	@Override
	public int removeOne(int s_id, int sl_id) {
		String sql = "delete from songlistwithsong where slws_songId=? and slws_songlistid=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql, s_id,sl_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

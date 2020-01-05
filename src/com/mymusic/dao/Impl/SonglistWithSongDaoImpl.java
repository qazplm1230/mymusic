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
 * ʵ����
 * �赥������
 * @author
 *
 */
public class SonglistWithSongDaoImpl implements SonglistWithSongDao{

	/**
	 * ���ݸ赥��Ų�ѯ�赥�������ж�Ӧ�Ķ�����¼
	 * @param slws_songId 	�赥���
	 * @return		��ѯ���Ķ�����¼����
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
	 * ���ݸ���id�͸赥id�����ø�������赥
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
	 * ���ݸ�����ź͸赥��ţ�ɾ��������¼
	 * @param s_id	�������
	 * @param sl_id	�赥���
	 * @return	��Ӱ�������
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

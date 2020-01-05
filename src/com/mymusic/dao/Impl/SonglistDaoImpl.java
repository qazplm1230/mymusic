package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.SonglistDao;
import com.mymusic.entity.Songlist;
import com.mymusic.util.DBUtil;
/**
 * ʵ����
 * ʵ���û��赥��ĸ��ֲ�������
 * @author 
 *
 */
public class SonglistDaoImpl implements SonglistDao{
	/**
	 * �����û���Ų�ѯ��Ӧ���������и赥
	 * @param sl_userId  �û����
	 * @return	�û������ĸ赥����
	 */
	@Override
	public List<Songlist> querySonglistsByUserId(int sl_userId) {
		String sql = "select * from songlist where sl_userId=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Songlist> list = new ArrayList<>();
		try {
			list = (List<Songlist>) runner.query(sql, new BeanListHandler(Songlist.class), sl_userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * �����û�id�����û��赥
	 * @param u_id
	 * @return ����һ���û��赥����
	 */
	@Override
	public List<Songlist> findUserSongList(int u_id) {
		String sql = "select * from songlist where sl_userId=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		List<Songlist> userSonglists = null;
		try {
			userSonglists = qr.query(sql, new BeanListHandler<Songlist>(Songlist.class),u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userSonglists;
	}

	/**
	 * ���ݸ赥��Ų�ѯ��Ӧ��һ���赥
	 * @param sl_id		�赥���
	 * @return		һ���赥
	 */
	@Override
	public Songlist querySonglistsById(int sl_id) {
		String sql = "select * from songlist where sl_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Songlist songlist = null;
		try {
			songlist = (Songlist) runner.query(sql, new BeanHandler(Songlist.class), sl_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songlist;
	}

	/**
	 * ���赥���в���һ������
	 * @param songlist	�赥����
	 * @return	����ɹ��ı�־
	 */
	@Override
	public int insertOne(Songlist songlist) {
		String sql = "insert into songlist(sl_userId,sl_name,sl_accessCount,sl_collectionCount,sl_coverUrl,sl_stateId) values(?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,songlist.getSl_userId(),songlist.getSl_name(),songlist.getSl_accessCount(),songlist.getSl_collectionCount(),songlist.getSl_coverUrl(),songlist.getSl_stateId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
	}

	/**
	 * ��ѯ���и赥���ղ�����
	 * @return
	 */
	@Override
	public List<Songlist> queryAllSonglistOrderByCol() {
		String sql = "select * from songlist order by sl_collectionCount desc";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Songlist> list = new ArrayList<>();
		try {
			list = (List<Songlist>) runner.query(sql, new BeanListHandler(Songlist.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ����һ���¸赥
	 * @param songlist	�赥����
	 * @return	��Ӱ�������
	 */
	@Override
	public int createOneSonglist(Songlist songlist) {
		String sql = "insert into songlist(sl_userId,sl_name,sl_introduce,sl_tags,sl_coverUrl) values(?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,songlist.getSl_userId(),songlist.getSl_name(),
					songlist.getSl_introduce(),songlist.getSl_tags(),songlist.getSl_coverUrl());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ���ݸ赥����ѯ�Ƿ���ڸø赥
	 * @param sl_name	�赥��
	 * @return	һ���赥
	 */
	@Override
	public Songlist querySonglistsByName(String sl_name) {
		String sql = "select * from songlist where sl_name = ?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Songlist songlist = null;
		try {
			songlist = (Songlist) runner.query(sql, new BeanHandler(Songlist.class), sl_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songlist;
	}

	/**
	 * ɾ��һ���赥ͨ���赥���
	 * @param slId	�赥���
	 * @return
	 */
	@Override
	public int deleteOneBysl_id(int slId) {
		String sql = "delete from songlist where sl_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,slId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}

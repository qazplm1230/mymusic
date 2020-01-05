package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.SonglistWithUserDao;
import com.mymusic.entity.SonglistWithUser;
import com.mymusic.util.DBUtil;

/**
 * ʵ����
 * �û��ղظ赥��
 * @author 
 *
 */
public class SonglistWithUserDaoImpl implements SonglistWithUserDao{

	/**
	 * �����û���Ų�ѯ��Ӧ�Ķ����赥�ղؼ�¼
	 * @param slwu_userId		�û����
	 * @return		�����赥�ղؼ�¼
	 */
	@Override
	public List<SonglistWithUser> querySonglistWithUser(int slwu_userId) {
		String sql = "select * from songlistwithuser where slwu_userId=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<SonglistWithUser> list = new ArrayList<>();
		try {
			list = (List<SonglistWithUser>) runner.query(sql, new BeanListHandler(SonglistWithUser.class), slwu_userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ���ݸ赥��ź��û����ɾ��һ���ղظ赥��¼
	 * @param slId	�赥���
	 * @param u_id	�û����
	 * @return
	 */
	@Override
	public int deleteOne(int slId, int u_id) {
		String sql = "delete from songlistwithuser where slwu_songlistId=? and slwu_userId=? ";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,slId,u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	


}

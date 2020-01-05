package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.HearSongHistoryDao;
import com.mymusic.entity.HearSongHistory;
import com.mymusic.util.DBUtil;
import com.mysql.fabric.xmlrpc.base.Data;
	/**
	 * ʵ����
	 * ������ʷ��
	 * @author 
	 */
public class HearSongHistoryDaoImpl implements HearSongHistoryDao{

	/**
	 * �����û���Ų�ѯ���е������¼����ʱ������ʱ������ǰ��
	 * @param hsh_userId		�û����
	 * @return		������ʷ��¼
	 */
	@Override
	public List<HearSongHistory> queryHearSongHistories(int hsh_userId) {
		String sql = "select * from hearsonghistory where hsh_userId=? order by hsh_date desc";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<HearSongHistory> list = new ArrayList<>();
		try {
			list = (List<HearSongHistory>) runner.query(sql, new BeanListHandler(HearSongHistory.class), hsh_userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��������ʷ�������һ�������¼
	 * @param s_Id	�������
	 * @param u_Id	�û����
	 * @return	��Ӱ�������
	 */
	@Override
	public int insertOneHistory(int s_Id, int u_Id) {
		String sql = "insert into hearsonghistory(hsh_userId,hsh_songId,hsh_date) values(?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,u_Id,s_Id,new Date());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
}

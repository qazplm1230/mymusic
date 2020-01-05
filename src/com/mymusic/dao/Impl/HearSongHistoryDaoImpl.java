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
	 * 实现类
	 * 听歌历史表
	 * @author 
	 */
public class HearSongHistoryDaoImpl implements HearSongHistoryDao{

	/**
	 * 根据用户编号查询所有的听歌记录，按时间排序（时间大的在前）
	 * @param hsh_userId		用户编号
	 * @return		听歌历史记录
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
	 * 往听歌历史表中添加一条听歌记录
	 * @param s_Id	歌曲编号
	 * @param u_Id	用户编号
	 * @return	受影响的行数
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

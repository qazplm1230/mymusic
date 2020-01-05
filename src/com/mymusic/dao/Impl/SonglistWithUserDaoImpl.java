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
 * 实现类
 * 用户收藏歌单表
 * @author 
 *
 */
public class SonglistWithUserDaoImpl implements SonglistWithUserDao{

	/**
	 * 根据用户编号查询对应的多条歌单收藏记录
	 * @param slwu_userId		用户编号
	 * @return		多条歌单收藏记录
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
	 * 根据歌单编号和用户编号删除一个收藏歌单记录
	 * @param slId	歌单编号
	 * @param u_id	用户编号
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

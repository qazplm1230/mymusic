package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.SonglistCommentDao;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.SonglistComment;
import com.mymusic.util.DBUtil;
/**
 * 歌单评论表
 * @author 
 *
 */
public class SonglistCommentDaoImpl implements SonglistCommentDao{
	
	/**
	 * 根据歌单编号查询对应的所有评论记录
	 * @param sl_id	歌单编号
	 * @return	所有评论记录
	 */
	@Override
	public List<SonglistComment> queryBySonglistId(int sl_id) {
		String sql = "select * from songlistcomment where slc_songlistId = ?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<SonglistComment> list = new ArrayList<>();
		try {
			list = (List<SonglistComment>) runner.query(sql, new BeanListHandler(SonglistComment.class), sl_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 插入一条评论
	 * @param slComment	评论对象
	 * @return	受影响的行数
	 */
	@Override
	public int insertOneComment(SonglistComment slComment) {
		String sql = "insert into songlistcomment(slc_userId,slc_songlistId,slc_text,slc_time) values(?,?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,slComment.getSlc_userId(),slComment.getSlc_songlistId()
					,slComment.getSlc_text(),slComment.getSlc_time());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}

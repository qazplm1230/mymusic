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
 * �赥���۱�
 * @author 
 *
 */
public class SonglistCommentDaoImpl implements SonglistCommentDao{
	
	/**
	 * ���ݸ赥��Ų�ѯ��Ӧ���������ۼ�¼
	 * @param sl_id	�赥���
	 * @return	�������ۼ�¼
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
	 * ����һ������
	 * @param slComment	���۶���
	 * @return	��Ӱ�������
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

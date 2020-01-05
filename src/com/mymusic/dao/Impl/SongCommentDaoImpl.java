package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mymusic.dao.SongCommentDao;
import com.mymusic.entity.SongComment;
import com.mymusic.util.DBUtil;
/**
 * �������۱�
 * @author 
 *
 */
public class SongCommentDaoImpl implements SongCommentDao{

	/**
	 * ���ݸ�����Ų�ѯ���еĸ�������
	 * @param s_id
	 * @return
	 */
	@Override
	public List<SongComment> queryAllCommentsById(int s_id) {
		String sql = "select * from songcomment where sc_songId = ?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<SongComment> list = new ArrayList<>();
		try {
			list = (List<SongComment>) runner.query(sql, new BeanListHandler(SongComment.class), s_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ����һ������
	 * @param sComment	���۶���
	 * @return	��Ӱ�������
	 */
	@Override
	public int inserOneComment(SongComment sComment) {
		String sql = "insert into songcomment(sc_userId,sc_songId,sc_text,sc_time) values(?,?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,sComment.getSc_userId(),sComment.getSc_songId()
					,sComment.getSc_text(),sComment.getSc_time());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

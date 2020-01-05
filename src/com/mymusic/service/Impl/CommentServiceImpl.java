package com.mymusic.service.Impl;

import java.util.List;

import com.mymusic.dao.SongCommentDao;
import com.mymusic.dao.SonglistCommentDao;
import com.mymusic.dao.UserDao;
import com.mymusic.dao.Impl.SongCommentDaoImpl;
import com.mymusic.dao.Impl.SonglistCommentDaoImpl;
import com.mymusic.dao.Impl.UserDaoImpl;
import com.mymusic.entity.SongComment;
import com.mymusic.entity.SonglistComment;
import com.mymusic.service.CommentService;
/**
 * ʵ����
 * ����������йص�ҵ��
 * @author 
 *
 */
public class CommentServiceImpl implements CommentService{
	
	private SonglistCommentDao slCommentDao = new SonglistCommentDaoImpl();
	private SongCommentDao scDao = new SongCommentDaoImpl();
	
	private UserDao userDao = new UserDaoImpl();

	/**
	 * ��ʾ���й��ڸø赥������
	 * @param sl_id	�赥���
	 * @return	�������ۼ���
	 */
	@Override
	public List<SonglistComment> showAllSonglistComments(int sl_id) {
		List<SonglistComment> list = slCommentDao.queryBySonglistId(sl_id);
		for (SonglistComment songlistComment : list) {
			songlistComment.setUser(userDao.queryUserById(songlistComment.getSlc_userId()));
		}
		return list;
	}

	/**
	 * ��ʾ���й��ڸø�������
	 * @param s_id	�������
	 * @return	�������ۼ���
	 */
	@Override
	public List<SongComment> showAllSongComment(int s_id) {
		List<SongComment> list = scDao.queryAllCommentsById(s_id);
		for (SongComment songComment : list) {
			songComment.setUser(userDao.queryUserById(songComment.getSc_userId()));
		}
		return list;
	}

}

package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.SongComment;

/**
 * �������۱�
 * @author 
 *
 */
public interface SongCommentDao {

	/**
	 * ���ݸ�����Ų�ѯ���еĸ�������
	 * @param s_id
	 * @return
	 */
	List<SongComment> queryAllCommentsById(int s_id);
	
	/**
	 * ����һ������
	 * @param sComment	���۶���
	 * @return	��Ӱ�������
	 */
	int inserOneComment(SongComment sComment);
}

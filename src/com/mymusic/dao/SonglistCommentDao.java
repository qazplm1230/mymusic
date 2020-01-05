package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.SonglistComment;

/**
 * �赥���۱�
 * @author 
 *
 */
public interface SonglistCommentDao {

	/**
	 * ���ݸ赥��Ų�ѯ��Ӧ���������ۼ�¼
	 * @param sl_id	�赥���
	 * @return	�������ۼ�¼
	 */
	List<SonglistComment> queryBySonglistId(int sl_id);
	
	/**
	 * ����һ������
	 * @param slComment	���۶���
	 * @return	��Ӱ�������
	 */
	int insertOneComment(SonglistComment slComment);
}

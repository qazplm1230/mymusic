package com.mymusic.service;

import java.util.List;

import com.mymusic.entity.SongComment;
import com.mymusic.entity.SonglistComment;

/**
 * �ӿ�
 * �������к�������ص�ҵ��
 * @author 
 *
 */
public interface CommentService {

	/**
	 * ��ʾ���й��ڸø赥������
	 * @param sl_id	�赥���
	 * @return	�������ۼ���
	 */
	List<SonglistComment> showAllSonglistComments(int sl_id);
	
	/**
	 * ��ʾ���й��ڸø�������
	 * @param s_id	�������
	 * @return	�������ۼ���
	 */
	List<SongComment> showAllSongComment(int s_id);
}

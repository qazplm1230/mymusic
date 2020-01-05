package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.SonglistWithSong;

/**
 * �ӿ�
 * �赥������
 * @author 
 *
 */
public interface SonglistWithSongDao {

	/**
	 * ���ݸ赥��Ų�ѯ�赥�������ж�Ӧ�Ķ�����¼
	 * @param slws_songId 	�赥���
	 * @return		������¼����
	 */
	List<SonglistWithSong> querySonglistWithSongs(int slws_songlistId);
	
	/**
	 * ���ݸ���id�͸赥id�����ø�������赥
	 * @param sl_id
	 * @param s_id
	 * @return
	 */
	int addSongToSongList(int sl_id,int s_id);

	/**
	 * ���ݸ�����ź͸赥��ţ�ɾ��������¼
	 * @param s_id	�������
	 * @param sl_id	�赥���
	 * @return	��Ӱ�������
	 */
	int removeOne(int s_id, int sl_id);
}

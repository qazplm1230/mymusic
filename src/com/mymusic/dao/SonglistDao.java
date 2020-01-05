package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.Songlist;
/**
 * �ӿ�
 * ���崦���û��Լ������ĸ赥���������
 * @author 
 *
 */
public interface SonglistDao {

	/**
	 * �����û���Ų�ѯ��Ӧ���������и赥
	 * @param sl_userId  �û����
	 * @return	�û������ĸ赥����
	 */
	List<Songlist> querySonglistsByUserId(int sl_userId);
	
	/**
	 * �����û�id�����û��赥
	 * @param u_id
	 * @return ����һ���û��赥����
	 */
	List<Songlist> findUserSongList(int u_id);
	
	/**
	 * ���ݸ赥��Ų�ѯ��Ӧ��һ���赥
	 * @param sl_id		�赥���
	 * @return		һ���赥
	 */
	Songlist querySonglistsById(int sl_id);

	/**
	 * ���赥���в���һ������
	 * @param songlist	�赥����
	 * @return	����ɹ��ı�־
	 */
	int insertOne(Songlist songlist);

	/**
	 * ��ѯ���и赥���ղ�����
	 * @return
	 */
	List<Songlist> queryAllSonglistOrderByCol();
	
	/**
	 * ����һ���¸赥
	 * @param songlist	�赥����
	 * @return	��Ӱ�������
	 */
	int createOneSonglist(Songlist songlist);

	/**
	 * ���ݸ赥����ѯ�Ƿ���ڸø赥
	 * @param sl_name	�赥��
	 * @return	һ���赥
	 */
	Songlist querySonglistsByName(String sl_name);

	/**
	 * ɾ��һ���赥ͨ���赥���
	 * @param slId	�赥���
	 * @return
	 */
	int deleteOneBysl_id(int slId);
}

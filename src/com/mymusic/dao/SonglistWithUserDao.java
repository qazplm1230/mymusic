package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.SonglistWithUser;

/**
 * �ӿ�
 * �û��ղظ赥��
 * @author 
 *
 */
public interface SonglistWithUserDao {

	/**
	 * �����û���Ų�ѯ��Ӧ�Ķ����ղؼ�¼
	 * @param slwu_userId		�û����
	 * @return		�����ղؼ�¼
	 */
	List<SonglistWithUser> querySonglistWithUser(int slwu_userId);

	/**
	 * ���ݸ赥��ź��û����ɾ��һ���ղظ赥��¼
	 * @param slId	�赥���
	 * @param u_id	�û����
	 * @return
	 */
	int deleteOne(int slId, int u_id);
}

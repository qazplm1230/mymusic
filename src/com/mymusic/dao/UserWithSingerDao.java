package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.UserWithSinger;

/**
 * �ӿ�
 * ���崦���û��ղظ��ֱ�ĸ��ַ���
 * @author 
 *
 */
public interface UserWithSingerDao {

	/**
	 * ͨ���û���Ų�ѯ�ղر��ж�Ӧ�Ķ�����¼
	 * @param userId �û����
	 * @return ������¼
	 */
	List<UserWithSinger> queryUerWithSingers(int userId);
}

package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.Singer;

/**
 * �ӿ�
 * ����Ӹ��ֱ���ȡ�õĸ������ݷ���
 * @author 
 */
public interface SingerDao {

	/**
	 * ͨ���ղر�Ų�ѯ���ֱ��ж�Ӧ���ղصĸ�����Ϣ�����ظø���
	 * @param userId  �ղر��еĸ��ֱ��
	 * @return ���ղصĸ�����Ϣ
	 */
	Singer querySinger(int uws_SingerId);

	/**
	 * ���ݸ���ģ����ѯ����Ӧ�ĸ���
	 * @param songName	����
	 * @return	��Ӧ�ĸ���
	 */
	List<Singer> querySinger(String singerName);
		
	/**
	 * ���ݸ���id������� ���ظ��ֱ���ϸ��Ϣ
	 * @param sg_id
	 * @return ��ǰ������Ϣ
	 */
	Singer showOneSinger(int sg_id);
	
	/**
	 * ���ݸ�����id�ҵ����ֵ�ȫ����Ϣ
	 * @param s_id
	 * @return ��ǰ����
	 */
	Singer findSinger(int sg_id);
}

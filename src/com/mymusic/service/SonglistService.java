package com.mymusic.service;

import java.util.List;

import com.mymusic.entity.Songlist;

/**
 * �ӿ�
 * ����͸赥������ҵ��
 * @author 
 *
 */
public interface SonglistService {

	/**
	 * ��ȡ�ղ�����ǰʮ�ĸ赥
	 * @return
	 */
	List<Songlist> showTopCollectionSonglist();
	
	/**
	 * �����û�id�����û��赥
	 * @param u_id
	 * @return ����һ���û��赥����
	 */
	List<Songlist> findUserSongList(String u_id);
	
	/**
	 * ���ݸ赥�����ʾ�赥����
	 * @param sl_id		�赥���
	 * @return	�赥����ϸ��Ϣ
	 */
	Songlist  showDetailSonglist(int sl_id);
	
	/**
	 * ����һ���¸赥
	 * @param songlist	�赥����
	 * @return	��Ӱ�������
	 */
	int creatNewSonglist(Songlist songlist);

}

package com.mymusic.service;

import java.util.List;
import com.mymusic.entity.Area;
import com.mymusic.entity.Cd;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;

/**
 * �ӿ�
 * ����͸����йص�ҵ��
 * @author 
 *
 */
public interface SingerService {

	/**
	 * �����첽����ĸ������ص���Ӧ�ĸ���
	 * @param songName	����
	 * @return	��Ӧ�ĸ���
	 */
	List<Singer> showAjaxSingers(String singerName);
	
	/**
	 * ���ݸ���id������� ���ظ��ֱ���ϸ��Ϣ
	 * @param sg_id
	 * @return ��ǰ������Ϣ
	 */
	Singer showOneSinger(String sg_id);
	
	/**
	 * ���ݸ���id������� ���ص�������ϸ��Ϣ
	 * @param sg_id
	 * @return ���ֵĵ���
	 */
	Area showOneArea(String sg_id);
	
	/**
	 * ���ݸ��ֵ�id ��ѯ��Ӧ���ֵ�ר��
	 * @param sg_id
	 * @return һ��ר������
	 */
	List<Cd> singerCds(String sg_id);

	/**
	 * ���ݸ���id��ѯ��Ӧ���ֵĸ���
	 * @param sg_id
	 * @return һ����������
	 */
	List<Song> singerSongs(String sg_id);
}

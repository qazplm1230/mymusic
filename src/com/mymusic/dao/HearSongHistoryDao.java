package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.HearSongHistory;

/**
 * �ӿ�
 * ������ʷ��
 * @author 
 *
 */
public interface HearSongHistoryDao {

	/**
	 * �����û���Ų�ѯ���е������¼����ʱ������ʱ������ǰ��
	 * @param hsh_userId		�û����
	 * @return		������ʷ��¼
	 */
	List<HearSongHistory> queryHearSongHistories(int hsh_userId);
	
	/**
	 * ��������ʷ�������һ�������¼
	 * @param s_Id	�������
	 * @param u_Id	�û����
	 * @return	��Ӱ�������
	 */
	int insertOneHistory(int s_Id ,int u_Id);
}

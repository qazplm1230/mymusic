package com.mymusic.service;

import java.util.List;


import com.mymusic.entity.HearSongHistory;
import com.mymusic.entity.User;
/**
 * �ӿ�
 * ������û��йصĸ��ֲ�������
 * @author 
 *
 */
public interface UserActionService {
	
	/**
	 * ���ݣ��û��������룩��ѯ����һ���û���ȫ����Ϣ
	 * @param userName	�û���
	 * @param pwd	����
	 * @return	��Ӧ���û�ȫ����Ϣ
	 */
	User queryUser(String userName,String pwd);
	
	/**
	 * ���ݣ��û��������룬�Ա𣩴���һ�����û�
	 * @param userName	�û���
	 * @param pwd	����
	 * @param sex	�Ա�
	 * @return
	 */
	int doRegister(String userName,String pwd,String sex);

	/**
	 * ��ȡ�û���������ʷ
	 * @param u_id
	 * @return 
	 */
	public List<HearSongHistory> showHearSongHistory(int u_id);
	
	/**
	 * ���ݸ���id�͸赥id�����ø�������赥
	 * @param sl_id
	 * @param s_id
	 * @return
	 */
	int addSongToSongList(String sl_id,String s_id);
	
	//�û����Ͳ鿴
	
	int queryUserType(String u_loginId,String u_loginPwd);
}

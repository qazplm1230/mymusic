package com.mymusic.dao;


import com.mymusic.entity.User;

/**
 * �ӿ���
 * ������û������ȡ�����ݵĸ��ַ���
 * @author 
 *
 */
public interface UserDao {

	/**
	 * �����û����������ѯ����һ���û���ȫ����Ϣ
	 * @param userName	�û���
	 * @param pwd	����
	 * @return	��Ӧ���û�ȫ����Ϣ
	 */
	User queryUser(String userName,String pwd);
	
	/**
	 * ���û����в���һ������
	 * @param user	һ��user����
	 */
	int insertOne(User user);
	
	/**
	 * ͨ���û���Ų�ѯ���û�
	 * @param u_id	�û����
	 * @return	���û�
	 */
	User queryUserById(int u_id);
	
	//�û����Ͳ�ѯ
	
	int queryUserType(String u_loginId,String u_loginPwd);
}

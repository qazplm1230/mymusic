package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.UserWithCd;
/**
 * �ӿ�
 * �����û��ղ�ר����ĸ������ݿ��������
 * @author 
 *
 */
public interface UserWithCdDao {

	/**
	 * ͨ���û���Ų�ѯ�û�ר����Ķ�����¼
	 * @param userId	�û����
	 * @return	�û�ר����Ķ�����¼
	 */
	List<UserWithCd> queryUserWithCds(int userId);
}

package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.Type;

public interface TypeDao {

	/**
	 * ���ݸ������еķ���id�ҵ����ֵ�ȫ����Ϣ
	 * @param t_id
	 * @return ��ǰ���
	 */
	Type findType(int t_id);
	
	/**
	 * �������еĸ�������
	 * @return  һ������б�
	 */
	List<Type> finAllType();
}

package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.UserWithSingerDao;
import com.mymusic.entity.UserWithSinger;
import com.mymusic.util.DBUtil;
/**
 * ʵ����
 * ʵ���û��ղظ��ֱ�ĸ��ֲ�������
 * @author 
 *
 */
public class UserWithSingerDaoImpl implements UserWithSingerDao{

	/**
	 * ͨ���û���Ų�ѯ�ղر��ж�Ӧ�����ղؼ�¼
	 * @param userId �û����
	 * @return	�ղؼ�¼����
	 */
	@Override
	public List<UserWithSinger> queryUerWithSingers(int userId) {
		String sql = "select * from userwithsinger where uws_userId=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<UserWithSinger> list = new ArrayList<>();
		try {
			list = (List<UserWithSinger>) runner.query(sql,new BeanListHandler(UserWithSinger.class), userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}

}

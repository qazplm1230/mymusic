package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mymusic.dao.UserWithCdDao;
import com.mymusic.entity.UserWithCd;
import com.mymusic.util.DBUtil;
/**
 * ʵ����
 * ʵ���û�ר����ĸ������ݿ����
 * @author 
 *
 */
public class UserWithCdDaoImpl implements UserWithCdDao{

	/**
	 * ͨ���û���Ų�ѯ�û�ר����Ķ�����¼
	 * @param userId	�û����
	 * @return	�û�ר����Ķ�����¼
	 */
	@Override
	public List<UserWithCd> queryUserWithCds(int userId) {
		String sql = "select * from userwithcd where uwc_userId=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<UserWithCd> list = new ArrayList<>();
		try {
			list = (List<UserWithCd>) runner.query(sql, new BeanListHandler(UserWithCd.class), userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

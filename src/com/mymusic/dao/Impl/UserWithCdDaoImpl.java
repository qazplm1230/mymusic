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
 * 实现类
 * 实现用户专辑表的各种数据库操作
 * @author 
 *
 */
public class UserWithCdDaoImpl implements UserWithCdDao{

	/**
	 * 通过用户编号查询用户专辑表的多条记录
	 * @param userId	用户编号
	 * @return	用户专辑表的多条记录
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

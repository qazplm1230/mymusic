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
 * 实现类
 * 实现用户收藏歌手表的各种操作方法
 * @author 
 *
 */
public class UserWithSingerDaoImpl implements UserWithSingerDao{

	/**
	 * 通过用户编号查询收藏表中对应多条收藏记录
	 * @param userId 用户编号
	 * @return	收藏记录集合
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

package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.TypeDao;
import com.mymusic.entity.Type;
import com.mymusic.util.DBUtil;

public class TypeDaoImpl implements TypeDao {
	/**
	 * 根据歌曲类型编号查询该歌曲类型
	 * @param t_id
	 * @return 一种歌曲类型
	 */
	@Override
	public Type findType(int t_id) {
		String sql = "select * from type where t_id=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		Type type = null;
		try {
			type = qr.query(sql, new BeanHandler<Type>(Type.class),t_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	/**
	 * 根据类型等级查询此等级的所有类型
	 * @return  一种等级的所有类型
	 */
	@Override
	public List<Type> finAllType() {
		String sql = "select * from type where t_greed=2";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		List<Type> types = null;
		try {
			types = qr.query(sql, new BeanListHandler<Type>(Type.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return types;
	}
}

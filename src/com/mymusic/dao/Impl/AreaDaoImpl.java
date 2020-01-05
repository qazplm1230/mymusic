package com.mymusic.dao.Impl;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.mymusic.dao.AreaDao;
import com.mymusic.entity.Area;
import com.mymusic.util.DBUtil;

public class AreaDaoImpl implements AreaDao{

	/**
	 * 根据歌手id查出地区 返回地区表详细信息
	 * @param sg_id
	 * @return 歌手的地区
	 */
	@Override
	public Area findArea(int sg_id) {
		String sql = "select * from area where a_id=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		Area area = null;
		try {
			area = qr.query(sql, new BeanHandler<Area>(Area.class),sg_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return area;
	}
	
}

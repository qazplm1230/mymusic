package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.SingerDao;
import com.mymusic.entity.Singer;
import com.mymusic.util.DBUtil;
	/**
	 *实现类
	 *实现歌手表的各种操作
	 *@author 
	 *
	 */
public class SingerDaoImpl implements SingerDao{

	/**
	 * * 根据歌手表的歌手编号查询对应的歌手信息
	 * @param s_id	歌手编号
	 * @return		歌手信息

	 */
	@Override
	public Singer querySinger(int uws_SingerId) {
		String sql = "select * from singer where sg_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Singer singer = null;
		try {
			singer = (Singer) runner.query(sql, new BeanHandler(Singer.class), uws_SingerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return singer;
	}

	/**
	 *查询出所有的歌手名字模糊查询相关歌手
	 *@param sg_name	歌手名字
	 * @return		歌手信息
	 */
	@Override
	public List<Singer> querySinger(String singerName) {
		String sql = "select * from singer where sg_name like ?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Singer> singers = new ArrayList<>();
		try {
			singers = (List<Singer>) runner.query(sql, new BeanListHandler(Singer.class), "%"+singerName+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return singers;
	}
	
	/**
	 * 根据歌手编号查询歌手信息
     *@param sg_id	歌手编号
	 * @return		歌手信息
	 */
	@Override
	public Singer showOneSinger(int sg_id) {
		String sql = "select * from singer where sg_id=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		Singer singer = null;
		try {
			singer = qr.query(sql, new BeanHandler<Singer>(Singer.class),sg_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return singer;
	}

	/**根据歌手编号查询歌手信息
     *@param sg_id	歌手编号
	 * @return		歌手信息
	 */
	@Override
	public Singer findSinger(int sg_id) {
		String sql = "select * from singer where sg_id=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		Singer singer = null;
		try {
			singer = qr.query(sql, new BeanHandler<Singer>(Singer.class),sg_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return singer;
	}

}

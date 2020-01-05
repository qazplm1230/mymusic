package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mymusic.dao.SonglistDao;
import com.mymusic.entity.Songlist;
import com.mymusic.util.DBUtil;
/**
 * 实现类
 * 实现用户歌单表的各种操作方法
 * @author 
 *
 */
public class SonglistDaoImpl implements SonglistDao{
	/**
	 * 根据用户编号查询对应创建的所有歌单
	 * @param sl_userId  用户编号
	 * @return	用户创建的歌单集合
	 */
	@Override
	public List<Songlist> querySonglistsByUserId(int sl_userId) {
		String sql = "select * from songlist where sl_userId=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Songlist> list = new ArrayList<>();
		try {
			list = (List<Songlist>) runner.query(sql, new BeanListHandler(Songlist.class), sl_userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据用户id查找用户歌单
	 * @param u_id
	 * @return 返回一个用户歌单集合
	 */
	@Override
	public List<Songlist> findUserSongList(int u_id) {
		String sql = "select * from songlist where sl_userId=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		List<Songlist> userSonglists = null;
		try {
			userSonglists = qr.query(sql, new BeanListHandler<Songlist>(Songlist.class),u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userSonglists;
	}

	/**
	 * 根据歌单编号查询对应的一个歌单
	 * @param sl_id		歌单编号
	 * @return		一个歌单
	 */
	@Override
	public Songlist querySonglistsById(int sl_id) {
		String sql = "select * from songlist where sl_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Songlist songlist = null;
		try {
			songlist = (Songlist) runner.query(sql, new BeanHandler(Songlist.class), sl_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songlist;
	}

	/**
	 * 往歌单表中插入一条数据
	 * @param songlist	歌单对象
	 * @return	插入成功的标志
	 */
	@Override
	public int insertOne(Songlist songlist) {
		String sql = "insert into songlist(sl_userId,sl_name,sl_accessCount,sl_collectionCount,sl_coverUrl,sl_stateId) values(?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,songlist.getSl_userId(),songlist.getSl_name(),songlist.getSl_accessCount(),songlist.getSl_collectionCount(),songlist.getSl_coverUrl(),songlist.getSl_stateId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
	}

	/**
	 * 查询所有歌单按收藏排序
	 * @return
	 */
	@Override
	public List<Songlist> queryAllSonglistOrderByCol() {
		String sql = "select * from songlist order by sl_collectionCount desc";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Songlist> list = new ArrayList<>();
		try {
			list = (List<Songlist>) runner.query(sql, new BeanListHandler(Songlist.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 创建一个新歌单
	 * @param songlist	歌单对象
	 * @return	受影响的行数
	 */
	@Override
	public int createOneSonglist(Songlist songlist) {
		String sql = "insert into songlist(sl_userId,sl_name,sl_introduce,sl_tags,sl_coverUrl) values(?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,songlist.getSl_userId(),songlist.getSl_name(),
					songlist.getSl_introduce(),songlist.getSl_tags(),songlist.getSl_coverUrl());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据歌单名查询是否存在该歌单
	 * @param sl_name	歌单名
	 * @return	一个歌单
	 */
	@Override
	public Songlist querySonglistsByName(String sl_name) {
		String sql = "select * from songlist where sl_name = ?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Songlist songlist = null;
		try {
			songlist = (Songlist) runner.query(sql, new BeanHandler(Songlist.class), sl_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songlist;
	}

	/**
	 * 删除一个歌单通过歌单编号
	 * @param slId	歌单编号
	 * @return
	 */
	@Override
	public int deleteOneBysl_id(int slId) {
		String sql = "delete from songlist where sl_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		int result = 0;
		try {
			result = runner.execute(sql,slId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}

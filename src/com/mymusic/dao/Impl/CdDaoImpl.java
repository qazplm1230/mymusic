package com.mymusic.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mymusic.dao.CdDao;
import com.mymusic.entity.Cd;
import com.mymusic.util.DBUtil;
/**
 * 实现类
 * 实现专辑表的各种操作
 * @author 
 *
 */
public class CdDaoImpl implements CdDao{



	
	/**
	 * 根据用户专辑表的专辑编号查询对应的专辑信息
	 * @param uwc_cdId	专辑编号
	 * @return	专辑信息
	 */
	@Override
	public Cd queryCd(int uwc_cdId) {
		String sql = "select * from cd where c_id=?";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		Cd cd = null;
		try {
			cd = (Cd) runner.query(sql, new BeanHandler(Cd.class), uwc_cdId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cd;
	}

	/**
	 * 查询出所有的专辑
	 */
	@Override
	public List<Cd> queryAllCds() {
		String sql = "select * from cd ";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Cd> cds = new ArrayList<>();
		try {
			cds = (List<Cd>) runner.query(sql, new BeanListHandler(Cd.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cds;
	}
	
	/**
	 * 根据歌手的编号查询对应歌手的专辑
	 * @param sg_id 	歌手编号
	 * @return 一个专辑集合
	 */
	@Override
	public List<Cd> singerCds(int sg_id) {
		String sql = "select * from cd where c_singerId=?";
		QueryRunner qr = new QueryRunner(DBUtil.ds);
		List<Cd> cds= null;
		try {
			cds = qr.query(sql, new BeanListHandler<Cd>(Cd.class),sg_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cds;
	}
	
	@Override
	public Cd getById(int cid) {
		String sql ="select * from cd where c_id=?";  
		QueryRunner run =new QueryRunner(DBUtil.ds); 
		Cd cd = null;
		try {
			cd = (Cd) run.query(sql,new BeanHandler(Cd.class),cid);
		} catch (SQLException e) {		
			e.printStackTrace();
		}                	
		return cd;
	}

	@Override
	public List<Cd> getCDs() {
		String sql ="select* from cd ";    
		QueryRunner run =new QueryRunner(DBUtil.ds);     
		
		List ls = null;	
		try {
			ls = (List) run.query(sql,new BeanListHandler(Cd.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}                	
		return ls;
	}

	/**
	 * 查询最新的专辑
	 * @return 最新的专辑集合
	 */
	@Override
	public List<Cd> queryNewCds() {
		String sql = "select * from cd order by c_publishDate desc";
		QueryRunner runner = new QueryRunner(DBUtil.ds);
		List<Cd> cds = new ArrayList<>();
		try {
			cds = (List<Cd>) runner.query(sql, new BeanListHandler(Cd.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cds;
	}

}

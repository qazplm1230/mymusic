package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.Cd;

/**
 * 接口
 * 定义专辑表的各种方法
 * @author 
 */
public interface CdDao {

	/**
	 * 根据用户专辑表的专辑编号查询对应的专辑信息
	 * @param uwc_cdId	专辑编号
	 * @return	专辑信息
	 */
	Cd queryCd(int uwc_cdId);

	/**
	 * 查询出所有的专辑
	 * @return
	 */
	List<Cd> queryAllCds();
	
	/**
	 * 根据歌手的歌手编号查询对应歌手的专辑
	 * @param sg_id		歌手编号
	 * @return 一个专辑集合
	 */
	List<Cd> singerCds(int sg_id);
	
	Cd getById(int cid);
	
	List<Cd> getCDs();
	
	/**
	 * 查询最新的专辑
	 * @return 最新的专辑集合
	 */
	List<Cd> queryNewCds();

}

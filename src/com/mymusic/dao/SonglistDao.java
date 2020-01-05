package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.Songlist;
/**
 * 接口
 * 定义处理用户自己创建的歌单表操作方法
 * @author 
 *
 */
public interface SonglistDao {

	/**
	 * 根据用户编号查询对应创建的所有歌单
	 * @param sl_userId  用户编号
	 * @return	用户创建的歌单集合
	 */
	List<Songlist> querySonglistsByUserId(int sl_userId);
	
	/**
	 * 根据用户id查找用户歌单
	 * @param u_id
	 * @return 返回一个用户歌单集合
	 */
	List<Songlist> findUserSongList(int u_id);
	
	/**
	 * 根据歌单编号查询对应的一个歌单
	 * @param sl_id		歌单编号
	 * @return		一个歌单
	 */
	Songlist querySonglistsById(int sl_id);

	/**
	 * 往歌单表中插入一条数据
	 * @param songlist	歌单对象
	 * @return	插入成功的标志
	 */
	int insertOne(Songlist songlist);

	/**
	 * 查询所有歌单按收藏排序
	 * @return
	 */
	List<Songlist> queryAllSonglistOrderByCol();
	
	/**
	 * 创建一个新歌单
	 * @param songlist	歌单对象
	 * @return	受影响的行数
	 */
	int createOneSonglist(Songlist songlist);

	/**
	 * 根据歌单名查询是否存在该歌单
	 * @param sl_name	歌单名
	 * @return	一个歌单
	 */
	Songlist querySonglistsByName(String sl_name);

	/**
	 * 删除一个歌单通过歌单编号
	 * @param slId	歌单编号
	 * @return
	 */
	int deleteOneBysl_id(int slId);
}

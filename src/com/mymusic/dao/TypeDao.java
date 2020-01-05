package com.mymusic.dao;

import java.util.List;

import com.mymusic.entity.Type;

public interface TypeDao {

	/**
	 * 根据歌曲表中的分类id找到歌手的全部信息
	 * @param t_id
	 * @return 当前类别
	 */
	Type findType(int t_id);
	
	/**
	 * 查找所有的歌曲类型
	 * @return  一个类别列表
	 */
	List<Type> finAllType();
}

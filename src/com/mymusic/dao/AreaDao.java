package com.mymusic.dao;

import com.mymusic.entity.Area;

public interface AreaDao {

	/**
	 * 根据歌手id查出地区 返回地区表详细信息
	 * @param sg_id
	 * @return 歌手的地区
	 */
	Area findArea(int sg_id);
}

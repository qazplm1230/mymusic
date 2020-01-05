package com.mymusic.dao;

import java.util.List;
import com.mymusic.entity.HearSongHistory;

/**
 * 接口
 * 听歌历史表
 * @author 
 *
 */
public interface HearSongHistoryDao {

	/**
	 * 根据用户编号查询所有的听歌记录，按时间排序（时间大的在前）
	 * @param hsh_userId		用户编号
	 * @return		听歌历史记录
	 */
	List<HearSongHistory> queryHearSongHistories(int hsh_userId);
	
	/**
	 * 往听歌历史表中添加一条听歌记录
	 * @param s_Id	歌曲编号
	 * @param u_Id	用户编号
	 * @return	受影响的行数
	 */
	int insertOneHistory(int s_Id ,int u_Id);
}

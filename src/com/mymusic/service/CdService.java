package com.mymusic.service;

import java.util.List;
import com.mymusic.entity.Cd;

/**
 * 接口
 * 处理和专辑有关的业务
 * @author 
 *
 */
public interface CdService {

	/**
	 * 查询出所有的专辑
	 * @param cid
	 * @return
	 */
	List<Cd> showAllCds();
	/**
	 * 根据专辑编号查询专辑
	 * @param cid
	 * @return
	 */
	Cd getById(int cid);
	/**
	 * 获取所有专辑
	 * @return
	 */
	List<Cd> getCDs();
	
	/**
	 * 显示最新的专辑
	 * @return
	 */
	List<Cd> showNewCds();
	
	/**
	 * 根据歌手编号显示相似的专辑
	 * @param sg_id
	 * @return
	 */
	List<Cd> showSameCds(int sg_id);
}

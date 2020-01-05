package com.mymusic.service;

import java.util.List;
import com.mymusic.entity.Cd;

/**
 * �ӿ�
 * �����ר���йص�ҵ��
 * @author 
 *
 */
public interface CdService {

	/**
	 * ��ѯ�����е�ר��
	 * @param cid
	 * @return
	 */
	List<Cd> showAllCds();
	/**
	 * ����ר����Ų�ѯר��
	 * @param cid
	 * @return
	 */
	Cd getById(int cid);
	/**
	 * ��ȡ����ר��
	 * @return
	 */
	List<Cd> getCDs();
	
	/**
	 * ��ʾ���µ�ר��
	 * @return
	 */
	List<Cd> showNewCds();
	
	/**
	 * ���ݸ��ֱ����ʾ���Ƶ�ר��
	 * @param sg_id
	 * @return
	 */
	List<Cd> showSameCds(int sg_id);
}

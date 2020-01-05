package com.mymusic.service;


import java.sql.SQLException;
import java.util.List;

import com.mymusic.entity.PageBean;
import com.mymusic.entity.User;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.Type;

/**
 * �ӿ�
 * ����͸�����ص�ҵ��
 * @author 
 *
 */
public interface SongService {
	
	/**
	 * ��ʾ���и���
	 * @return
	 */
	List<Song> showAllSongs();
	
	/**
	 * ���ղ��Ŵ�����ʾ���и�����ʾ
	 * @return
	 */
	List<Song> showAllSongsOrderByPlay();
	
	/**
	 * �����첽����ĸ������ص���Ӧ�ĸ���
	 * @param songName	����
	 * @return	��Ӧ�ĸ���
	 */
	List<Song> showAjaxSongs(String songName);
	
	/**
	 * ���ݸ�����id�ҵ���ǰ������ȫ����Ϣ
	 * @param s_id
	 * @return ��ǰ����
	 */
	Song findSong(String s_id);
	
	/**
	 * ���ݸ������еĸ���id�ҵ����ֵ�ȫ����Ϣ
	 * @param sg_id
	 * @return ��ǰ����
	 */
	Singer findSinger(int sg_id);
	
	/**
	 * ���ݸ������еķ���id�ҵ����ֵ�ȫ����Ϣ
	 * @param t_id
	 * @return ��ǰ���
	 */
	Type findType(int t_id);
	
	/**
	 * �������еĸ�������
	 * @return  һ������б�
	 */
	List<Type> finAllType();
	
	/**
	 * ���ݸ��������ҵ����Ƶĸ���
	 * @param s_type
	 * @return  ���Ƹ�������
	 */
	List<Song> findLikeSongs(int s_typeId);
	
	/**
	 * ���ݸ赥id�������и���
	 * @param sl_id
	 * @return �û���һ���赥�ĸ�������
	 */
	List<Song> findUserSongs(int sl_id);
	
	Song getById(int sid);
	List getByTypeId(int tid);
	Singer getSingerById(int sgid);
	List getSingersById(int sgid);
	
	/**
	 * �����û�id�����û��赥
	 * @param u_id
	 * @return ����һ���û��赥����
	 */
	List<Songlist> findUserSongList(int u_id);
	
	//��̨����
	
	int addSong(String s_name,String s_singername,String sp[]);
	PageBean getPage(String page,int size);
	//User login(String uname,String upass);
	int delSong(String s_id);
	int updateSong(String s_id, String s_name, String s_singername, String sp[]) throws SQLException;
}

package com.mymusic.dao;

import java.sql.SQLException;
import java.util.List;

import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
/**
 * �ӿ�
 * ������
 * @author 
 *
 */
public interface SongDao {

	/**
	 * ���ݸ�����Ų�ѯ��Ӧ�ĸ���
	 * @param s_id		�������
	 * @return		һ������
	 */
	Song querySong(int s_id);

	/**
	 * ��ѯ���и���
	 * @return
	 */
	List<Song> queryAllSongsorderByTime();

	/**
	 * ���ղ�������ѯ���еĸ���
	 * @return
	 */
	List<Song> queryAllSongsorderByPlay();

	/**
	 * �����ַ���ģ����ѯ��Ӧ�ĸ���
	 * @return	��������
	 */
	List<Song> querySongLikeString(String songName);
	
	/**
	 * ���ݸ��ֵ�id  ��ѯ���иø��ֵĸ���
	 * @param sg_id
	 * @return  һ�������ļ���
	 */
	List<Song> singerSongs(int sg_id);
	
	/**
	 * ���ݸ�����id�ҵ���ǰ������ȫ����Ϣ
	 * @param s_id
	 * @return ��ǰ����
	 */
	Song findSong(int s_id);
	
	/**
	 * ���ݸ��������ҵ����Ƶĸ���
	 * @param s_type
	 * @return  ���Ƹ�������
	 */
	List<Song> likeSongs(int s_type);
	
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
	 * ����ר����ţ���ѯ�����еĸ���
	 * @param s_cdId	ר�����
	 * @return	���еĸ���
	 */
	List<Song> querySongsToCd(int s_cdId);
	
	//��̨��������
	
	Song getSongById(int s_id)  throws SQLException;	
	
	int delSong(int s_id) throws SQLException;
	
	int addSong(Song obj) throws SQLException;
	
	long getCount()throws SQLException;
	
	List<Song> getPage(int page, int size) throws SQLException;
	
	int updateSong(Song obj) throws SQLException;
}

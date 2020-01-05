package com.mymusic.service.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymusic.entity.PageBean;

import com.mymusic.dao.SingerDao;
import com.mymusic.dao.SongDao;
import com.mymusic.dao.SonglistDao;
import com.mymusic.dao.TypeDao;
import com.mymusic.dao.UserDao;
import com.mymusic.dao.Impl.SingerDaoImpl;
import com.mymusic.dao.Impl.SongDaoImpl;
import com.mymusic.dao.Impl.SonglistDaoImpl;
import com.mymusic.dao.Impl.TypeDaoImpl;
import com.mymusic.dao.Impl.UserDaoImpl;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.Type;
import com.mymusic.entity.User;
import com.mymusic.service.SongService;
/**
 * ʵ����
 * ����͸�����ص�ҵ��
 * @author 
 *
 */
public class SongServiceImpl implements SongService{

	//����SongDao
		private SongDao songDao = new SongDaoImpl();
		//����SingerDao
		private SingerDao singerDao = new SingerDaoImpl();
		private TypeDao tdao = new TypeDaoImpl();
		private SonglistDao songlistDao = new SonglistDaoImpl();
		private UserDao userDao=new UserDaoImpl();
		/**
		 * �����û�id�����û��赥
		 * @param u_id
		 * @return ����һ���û��赥����
		 */
		@Override
		public List<Songlist> findUserSongList(int u_id) {
			List<Songlist> userSonglists = songlistDao.findUserSongList(u_id);
			return userSonglists;
		}
		
		/**
		 * ��ʾ���и���
		 * @return
		 */
		@Override
		public List<Song> showAllSongs() {
			List<Song> songs = new ArrayList<>();
			songs = songDao.queryAllSongsorderByTime();
			Singer singer = null;
			for (Song song : songs) {
				singer = singerDao.querySinger(song.getS_singerId());
				song.setSinger(singer);
			}
			return songs;
		}

		/**
		 * ���ղ��Ŵ�����ʾ���и�����ʾ
		 * @return
		 */
		@Override
		public List<Song> showAllSongsOrderByPlay() {
			List<Song> songs = new ArrayList<>();
			songs = songDao.queryAllSongsorderByPlay();
			Singer singer = null;
			for (Song song : songs) {
				singer = singerDao.querySinger(song.getS_singerId());
				song.setSinger(singer);
			}
			return songs;
		}

		/**
		 * �����첽����ĸ���������Ӧ�ĸ���
		 * @param songName	����
		 * @return	
		 */
		@Override
		public List<Song> showAjaxSongs(String songName) {
			List<Song> songs = songDao.querySongLikeString(songName);
			Singer singer = null;
			for (Song song : songs) {
				singer = singerDao.querySinger(song.getS_singerId());
				song.setSinger(singer);
			}
			return songs;
		}
		
		/**
		 * �жϴ����ֵ�Ƿ�Ϊ��
		 * @param �ַ��� s_id
		 * @return ������ id
		 */
		private static int Check(String s_id){
			int id=0;
			if (s_id==null&&s_id=="") {
				id=1;
			}else{
				id=Integer.parseInt(s_id);
			}
			return id;
		}
		
		/**
		 * ���ݸ�����id�ҵ���ǰ������ȫ����Ϣ
		 * @param s_id
		 * @return ��ǰ����
		 */
		@Override
		public Song findSong(String s_id) {
			int id = Check(s_id);
			Song song = songDao.findSong(id);
			return song;
		}

		/**
		 * ���ݸ�����id�ҵ����ֵ�ȫ����Ϣ
		 * @param s_id
		 * @return ��ǰ����
		 */
		@Override
		public Singer findSinger(int sg_id) {
			Singer singer = singerDao.findSinger(sg_id);
			return singer;
		}

		/**
		 * ���ݸ������еķ���id�ҵ������ȫ����Ϣ
		 * @param t_id
		 * @return ��ǰ���
		 */
		@Override
		public Type findType(int t_id) {
			Type type = tdao.findType(t_id);
			return type;
		}

		/**
		 * ���ݸ��������ҵ����Ƶĸ���
		 * @param s_type
		 * @return  ���Ƹ�������
		 */
		@Override
		public List<Song> findLikeSongs(int s_typeId) {
			List<Song> songs  = songDao.likeSongs(s_typeId);
			for (Song song : songs) {
				song.setSinger(singerDao.showOneSinger(song.getS_singerId()));
			}
			return songs;
		}

		/**
		 * ���ݸ赥id�������и���
		 * @param sl_id
		 * @return �û���һ���赥�ĸ�������
		 */
		@Override
		public List<Song> findUserSongs(int sl_id) {
			List<Song> songs  = songDao.findUserSongs(sl_id);
			return songs;
		}

		/**
		 * ���ݸ��������ҵ����Ƶĸ���
		 * @param s_type
		 * @return  ���Ƹ�������
		 */
		@Override
		public List<Type> finAllType() {
			List<Type> types = tdao.finAllType();
			return types;
		}
		
		@Override
		public Song getById(int sid) {
			Song song=songDao.getById(sid);
			return song;
		}

		@Override
		public List getByTypeId(int tid) {
			List songls=songDao.getByTypeId(tid);		
			return songls;
		}

		@Override
		public Singer getSingerById(int sgid) {
			Singer singer=songDao.getSingerById(sgid);
			return singer;
		}

		@Override
		public List getSingersById(int sgid) {
			List singers=songDao.getByTypeId(sgid);		
			return singers;
		}
		
	
		
		
		//��̨����
		
		public int addSong(String s_name,String s_singername,String sp[]){  //�����β�String���͵�word�������β�String���͵�cword,�����β�String���͵�sp[],
			int n =0;                                                          //����int���͵�����
			try {
				Song obj= new Song();                        
				obj.setS_name(s_name); 
				
				obj.setS_singername(s_singername);                         
				if(sp==null){
					obj.setS_languageType(null);
				}else{
					obj.setS_languageType(sp[0]);                    
				}
				
				n=songDao.addSong(obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;                                        //����int���͵�n
		}
		
		
		public PageBean getPage(String page,int size){       //�����β�String���͵�page�������β�int���͵�size,����PageBean���͵�����
			int intPage =0;
			if(page==null){
				intPage=1;
			}else{
				intPage= Integer.parseInt(page);             //��String���͵�pageת��int���͵�intpage
			}	
			PageBean pb=new PageBean();                      //����PageBean���ʵ��pb
			try {
				List list = songDao.getPage(intPage, size);  //һҳ����
				long n =songDao.getCount();                  //������
				pb.setTotalCount((int)n);                    //����������
				pb.setCurrPage(intPage);                     //���õ�ǰҳ��
				pb.setData(list);			
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return pb;                                       //����PageBean���͵�PageBean��ʵ��pb
		}


	//	@Override
	//	public User login(String uname, String upass) {
	//		User user=null;
	//		user=userDao.login(uname,upass);
	//		return user;
	//	}


		@Override
		public int delSong(String s_id) {
			int ok = 0;
			try {
				ok = songDao.delSong(Integer.parseInt(s_id));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ok;		
		}


		@Override
		public int updateSong(String s_id, String s_name,String s_singername, String sp[]) {
					
			int n =0;                                                          //����int���͵�����
			try {
				Song obj= new Song();                        //����һ��Word���ʵ��obj
				int ints_id=Integer.parseInt(s_id);
				
				obj.setS_id(ints_id);                            //����obj������wid��ֵΪwid
				obj.setS_name(s_name);                           //����obj������word��ֵΪword
				obj.setS_singername(s_singername);                         //����obj������cword��ֵΪcword
				if(sp==null){
					obj.setS_languageType(null);
				}else{
					obj.setS_languageType(sp[0]);                    //����obj������slevel��ֵΪsp[0]
				}
				
				n=songDao.updateSong(obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;                					
			
		}	
		
}

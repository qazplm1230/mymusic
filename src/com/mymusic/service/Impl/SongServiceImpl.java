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
 * 实现类
 * 处理和歌曲相关的业务
 * @author 
 *
 */
public class SongServiceImpl implements SongService{

	//声明SongDao
		private SongDao songDao = new SongDaoImpl();
		//声明SingerDao
		private SingerDao singerDao = new SingerDaoImpl();
		private TypeDao tdao = new TypeDaoImpl();
		private SonglistDao songlistDao = new SonglistDaoImpl();
		private UserDao userDao=new UserDaoImpl();
		/**
		 * 根据用户id查找用户歌单
		 * @param u_id
		 * @return 返回一个用户歌单集合
		 */
		@Override
		public List<Songlist> findUserSongList(int u_id) {
			List<Songlist> userSonglists = songlistDao.findUserSongList(u_id);
			return userSonglists;
		}
		
		/**
		 * 显示所有歌曲
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
		 * 按照播放次数显示所有歌曲显示
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
		 * 根据异步请求的歌名返回相应的歌曲
		 * @param songName	歌名
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
		 * 判断传入的值是否为空
		 * @param 字符型 s_id
		 * @return 整数型 id
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
		 * 根据歌曲的id找到当前歌曲的全部信息
		 * @param s_id
		 * @return 当前歌曲
		 */
		@Override
		public Song findSong(String s_id) {
			int id = Check(s_id);
			Song song = songDao.findSong(id);
			return song;
		}

		/**
		 * 根据歌曲的id找到歌手的全部信息
		 * @param s_id
		 * @return 当前歌手
		 */
		@Override
		public Singer findSinger(int sg_id) {
			Singer singer = singerDao.findSinger(sg_id);
			return singer;
		}

		/**
		 * 根据歌曲表中的分类id找到分类的全部信息
		 * @param t_id
		 * @return 当前类别
		 */
		@Override
		public Type findType(int t_id) {
			Type type = tdao.findType(t_id);
			return type;
		}

		/**
		 * 根据歌曲类型找到相似的歌曲
		 * @param s_type
		 * @return  相似歌曲集合
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
		 * 根据歌单id查找所有歌曲
		 * @param sl_id
		 * @return 用户第一个歌单的歌曲集合
		 */
		@Override
		public List<Song> findUserSongs(int sl_id) {
			List<Song> songs  = songDao.findUserSongs(sl_id);
			return songs;
		}

		/**
		 * 根据歌曲类型找到相似的歌曲
		 * @param s_type
		 * @return  相似歌曲集合
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
		
	
		
		
		//后台管理
		
		public int addSong(String s_name,String s_singername,String sp[]){  //传递形参String类型的word，传递形参String类型的cword,传递形参String类型的sp[],
			int n =0;                                                          //返回int类型的数据
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
			return n;                                        //返回int类型的n
		}
		
		
		public PageBean getPage(String page,int size){       //传递形参String类型的page，传递形参int类型的size,返回PageBean类型的数据
			int intPage =0;
			if(page==null){
				intPage=1;
			}else{
				intPage= Integer.parseInt(page);             //把String类型的page转成int类型的intpage
			}	
			PageBean pb=new PageBean();                      //创建PageBean类的实例pb
			try {
				List list = songDao.getPage(intPage, size);  //一页数据
				long n =songDao.getCount();                  //总条数
				pb.setTotalCount((int)n);                    //设置总条数
				pb.setCurrPage(intPage);                     //设置当前页数
				pb.setData(list);			
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return pb;                                       //返回PageBean类型的PageBean类实例pb
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
					
			int n =0;                                                          //返回int类型的数据
			try {
				Song obj= new Song();                        //创建一个Word类的实例obj
				int ints_id=Integer.parseInt(s_id);
				
				obj.setS_id(ints_id);                            //设置obj的属性wid的值为wid
				obj.setS_name(s_name);                           //设置obj的属性word的值为word
				obj.setS_singername(s_singername);                         //设置obj的属性cword的值为cword
				if(sp==null){
					obj.setS_languageType(null);
				}else{
					obj.setS_languageType(sp[0]);                    //设置obj的属性slevel的值为sp[0]
				}
				
				n=songDao.updateSong(obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;                					
			
		}	
		
}

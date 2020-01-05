package com.mymusic.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mymusic.dao.HearSongHistoryDao;
import com.mymusic.dao.Impl.HearSongHistoryDaoImpl;
import com.mymusic.entity.HearSongHistory;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.entity.SongComment;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.SonglistComment;
import com.mymusic.entity.Type;
import com.mymusic.entity.User;
import com.mymusic.service.CommentService;
import com.mymusic.service.SongService;
import com.mymusic.service.UserActionService;
import com.mymusic.service.Impl.CommentServiceImpl;
import com.mymusic.service.Impl.SongServiceImpl;
import com.mymusic.service.Impl.UserActionServiceImpl;
/**
 * 
 * doShowSongDetail doDiscoverSong doShowNewSong doShowTopSong         
 * doShowSongType   doShowTypeAllSong    doShowLikeSong    doShowUserSong

 *
 */
@WebServlet("/song")
public class SongServlet extends HttpServlet{
	
	SongService sservice = new SongServiceImpl();
	private CommentService cService = new CommentServiceImpl();
	private HearSongHistoryDao hshDao = new HearSongHistoryDaoImpl();
	private UserActionService uaService = new UserActionServiceImpl();

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		

		String method = arg0.getParameter("method");
		
		if ("doShowSongDetail".equals(method)) {
			doShowSongDetail(arg0, arg1);
		} else if ("doGsonSong".equals(method)) {
			doGsonSong(arg0, arg1);
		}else if ("doShowNewSong".equals(method)) {
			doShowNewSong(arg0,arg1);
		}else if ("doShowTopSong".equals(method)) {
			doShowTopSong(arg0,arg1);
		}else if ("doShowSongType".equals(method)) {
			doShowSongType(arg0,arg1);
		}else if ("doShowTypeAllSong".equals(method)) {
			doShowTypeAllSong(arg0,arg1);
		}else if ("doShowLikeSong".equals(method)) {
			doShowLikeSong(arg0,arg1);
		}else if ("doShowUserSong".equals(method)) {
			doShowUserSong(arg0,arg1);
		}
		
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	private void doShowUserSong(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		Integer sl_id = (Integer) arg0.getAttribute("sl_id");
		List<Song> usersongs = sservice.findUserSongs( sl_id);
		arg0.setAttribute("usersongs", usersongs);
		try {
			arg0.getRequestDispatcher("jsp/listen.jsp").forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	private void doShowLikeSong(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		String s_id = arg0.getParameter("s_id");
		Song song = sservice.findSong(s_id);
		int s_typeId = song.getS_typeId();
		List<Song> likesongs = sservice.findLikeSongs(s_typeId);
		arg0.setAttribute("likesongs", likesongs);
		try {
			arg0.getRequestDispatcher("jsp/song-detail.jsp").forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void doShowTypeAllSong(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		String t_id = arg0.getParameter("t_id");
		int s_typeId = Integer.parseInt(t_id);
		List<Song> typeSongs = sservice.findLikeSongs(s_typeId);
		arg0.setAttribute("typeSongs", typeSongs);
		try {
			arg0.getRequestDispatcher("jsp/song.jsp").forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void doShowSongType(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		String t_id = arg0.getParameter("t_id")==null?"1":arg0.getParameter("t_id");
		List<Type> types = sservice.finAllType();
		arg0.setAttribute("types", types);
		try {
			arg0.getRequestDispatcher("song?method=doShowTypeAllSong&t_id="+t_id).forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void doShowTopSong(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		
	}

	private void doShowNewSong(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws IOException
	 */
	private void doGsonSong(HttpServletRequest arg0,
			HttpServletResponse arg1) throws IOException {
		
		arg1.setContentType("application/json");
		String songId = arg0.getParameter("songId");
		int s_Id = Integer.parseInt(songId);
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			hshDao.insertOneHistory(s_Id, user.getU_id());
			List<HearSongHistory> list = uaService.showHearSongHistory(user.getU_id());
			user.setHeardSongs(list);
			session.setAttribute("user", user);
		}
		Song song = sservice.findSong(songId);
		Gson gson = new Gson();
		String songString = gson.toJson(song);
		arg1.getWriter().print(songString);
		
	}

	/**
	 * ¥¶¿Ì∏Ë«˙œÍ«È“≥
	 * @param arg0
	 * @param arg1
	 */
	private void doShowSongDetail(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		String s_id = arg0.getParameter("s_id");
		int songId = Integer.parseInt(s_id);
		Song song = sservice.findSong(s_id);
		int sg_id = song.getS_singerId();
		Singer singer = sservice.findSinger(sg_id);
		int t_id = song.getS_typeId();
		Type type = sservice.findType(t_id);
		arg0.setAttribute("song", song);
		arg0.setAttribute("singer", singer);
		arg0.setAttribute("type", type);
		
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null){
			int u_id = user.getU_id();
			List<Songlist> usersongLists = sservice.findUserSongList(u_id);
			arg0.setAttribute("usersongLists", usersongLists);
		}
		
		List<SongComment> sComments = cService.showAllSongComment(songId);
		arg0.setAttribute("sComments", sComments);
		try {
			arg0.getRequestDispatcher("song?method=doShowLikeSong").forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}

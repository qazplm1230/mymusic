package com.mymusic.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mymusic.dao.SongCommentDao;
import com.mymusic.dao.SonglistCommentDao;
import com.mymusic.dao.Impl.SongCommentDaoImpl;
import com.mymusic.dao.Impl.SonglistCommentDaoImpl;
import com.mymusic.entity.SongComment;
import com.mymusic.entity.SonglistComment;
import com.mymusic.entity.User;
import com.mysql.fabric.xmlrpc.base.Data;

/** 处理所有和评论相关的请求 
 * doSongListComment doSongComment doCDComment
 */
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	
	private SonglistCommentDao slcDao = new SonglistCommentDaoImpl();
	private SongCommentDao scDao = new SongCommentDaoImpl();
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {

		String method = arg0.getParameter("method");

		if ("doSongListComment".equals(method)) {
			doSongListComment(arg0, arg1);
		} else if ("doSongComment".equals(method)) {
			doSongComment(arg0, arg1);
		} 
	}

	
	private void doSongComment(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		//获取歌曲编号
		String sc_songId = arg0.getParameter("sc_songId");
		int sc_sId = Integer.parseInt(sc_songId);
		//获取评论内容
		String sc_text = arg0.getParameter("s_text");
		//获取当前用户编号
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		int sc_userId = user.getU_id();
		//创建评论对象
		SongComment comment = new SongComment();
		comment.setSc_songId(sc_sId);
		comment.setSc_userId(sc_userId);
		comment.setSc_text(sc_text);
		comment.setSc_time(new Date());
		int result = scDao.inserOneComment(comment);
		//转发到显示歌单详情页
		arg0.getRequestDispatcher("song?method=doShowSongDetail&s_id="+sc_sId).forward(arg0, arg1);		
	}

	private void doSongListComment(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		
		//获取歌单编号
		String slc_songlistId = arg0.getParameter("slc_songlistId");
		int slc_slId = Integer.parseInt(slc_songlistId);
		//获取评论内容
		String slc_text = arg0.getParameter("slc_text");
		//获取当前用户编号
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		int slc_userId = user.getU_id();
		//创建评论对象
		SonglistComment comment = new SonglistComment();
		comment.setSlc_songlistId(slc_slId);
		comment.setSlc_text(slc_text);
		comment.setSlc_userId(slc_userId);
		comment.setSlc_time(new Date());
		int result = slcDao.insertOneComment(comment);
		//转发到显示歌单详情页
		arg0.getRequestDispatcher("songlist?method=doShowSongListDetail&sl_id="+slc_songlistId).forward(arg0, arg1);
	}
}
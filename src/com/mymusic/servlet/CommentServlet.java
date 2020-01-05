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

/** �������к�������ص����� 
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
		
		//��ȡ�������
		String sc_songId = arg0.getParameter("sc_songId");
		int sc_sId = Integer.parseInt(sc_songId);
		//��ȡ��������
		String sc_text = arg0.getParameter("s_text");
		//��ȡ��ǰ�û����
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		int sc_userId = user.getU_id();
		//�������۶���
		SongComment comment = new SongComment();
		comment.setSc_songId(sc_sId);
		comment.setSc_userId(sc_userId);
		comment.setSc_text(sc_text);
		comment.setSc_time(new Date());
		int result = scDao.inserOneComment(comment);
		//ת������ʾ�赥����ҳ
		arg0.getRequestDispatcher("song?method=doShowSongDetail&s_id="+sc_sId).forward(arg0, arg1);		
	}

	private void doSongListComment(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		
		//��ȡ�赥���
		String slc_songlistId = arg0.getParameter("slc_songlistId");
		int slc_slId = Integer.parseInt(slc_songlistId);
		//��ȡ��������
		String slc_text = arg0.getParameter("slc_text");
		//��ȡ��ǰ�û����
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		int slc_userId = user.getU_id();
		//�������۶���
		SonglistComment comment = new SonglistComment();
		comment.setSlc_songlistId(slc_slId);
		comment.setSlc_text(slc_text);
		comment.setSlc_userId(slc_userId);
		comment.setSlc_time(new Date());
		int result = slcDao.insertOneComment(comment);
		//ת������ʾ�赥����ҳ
		arg0.getRequestDispatcher("songlist?method=doShowSongListDetail&sl_id="+slc_songlistId).forward(arg0, arg1);
	}
}
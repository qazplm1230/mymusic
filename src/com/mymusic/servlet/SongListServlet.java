package com.mymusic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mymusic.dao.SonglistDao;
import com.mymusic.dao.SonglistWithSongDao;
import com.mymusic.dao.SonglistWithUserDao;
import com.mymusic.dao.Impl.SonglistDaoImpl;
import com.mymusic.dao.Impl.SonglistWithSongDaoImpl;
import com.mymusic.dao.Impl.SonglistWithUserDaoImpl;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.SonglistComment;
import com.mymusic.entity.User;
import com.mymusic.service.CommentService;
import com.mymusic.service.SonglistService;
import com.mymusic.service.Impl.CommentServiceImpl;
import com.mymusic.service.Impl.SonglistServiceImpl;
/**
 * �������к͸赥��ص�����
 * doShowTopSongList   doShowLoveSongList   doShowUserSongList  
 * doRemoveSongFromSonglist  doDeleteUserSonglist  doShowSongListDetail doDeleteCollectionSonglist
 *
 */
@WebServlet("/songlist")
public class SongListServlet extends HttpServlet{
	
	private SonglistService slservice = new SonglistServiceImpl();
	
	private SonglistWithSongDao slwsDao = new SonglistWithSongDaoImpl();
	
	private CommentService commentService = new CommentServiceImpl();
	
	private SonglistDao slDao = new SonglistDaoImpl();
	
	private SonglistWithUserDao slwuDao = new SonglistWithUserDaoImpl();
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		// �����������method��ֵ�ҵ�ƥ��ķ������������,�����ǿյ�
		// �ɴ�����������ȥ��д������,����д�÷���ע��
		String method = arg0.getParameter("method");
		
		if ("doShowTopSongList".equals(method)) {
			doShowTopSongList(arg0, arg1);
		} else if ("doDeleteCollectionSonglist".equals(method)) {
			doDeleteCollectionSonglist(arg0, arg1);
		}else if ("doShowUserSongList".equals(method)) {
			doShowUserSongList(arg0,arg1);
		}else if ("doRemoveSongFromSonglist".equals(method)) {
			doRemoveSongFromSonglist(arg0,arg1);
		}else if ("doDeleteUserSonglist".equals(method)) {
			doDeleteUserSonglist(arg0,arg1);
		}else if ("doShowSongListDetail".equals(method)) {
			doShowSongListDetail(arg0,arg1);
		}else if ("doCreateNewSongList".equals(method)) {
			doCreateNewSongList(arg0,arg1);
		}
		
	}

	
	/**
	 * �������¸赥
	 * @param arg0
	 * @param arg1
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doCreateNewSongList(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		
		//��ȡǰ̨����
		String sl_name = arg0.getParameter("sl_name");
		String sl_introduce = arg0.getParameter("sl_introduce");
		String sl_tags = arg0.getParameter("sl_tags");
		HttpSession session = arg0.getSession();
		//��session�л�ȡuser����
		User user = (User) session.getAttribute("user");
		Songlist songlist = new Songlist();
		songlist.setSl_coverUrl("resource/sl_images/default.PNG");
		songlist.setSl_introduce(sl_introduce);
		songlist.setSl_name(sl_name);
		songlist.setSl_tags(sl_tags);
		songlist.setSl_userId(user.getU_id());
		int result = slservice.creatNewSonglist(songlist);
		if (result > 0) {
			arg0.setAttribute("status", 2);
		}else {
			arg0.setAttribute("status", 1);
		}
		arg0.getRequestDispatcher("user?method=doShowMySonglist").forward(arg0, arg1);
		
	}

	/**
	 * ����ɾ��һ���û��赥������
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 */
	private void doDeleteUserSonglist(HttpServletRequest arg0,
			HttpServletResponse arg1) throws IOException {
		//��ȡ�������
		String sl_id = arg0.getParameter("sl_id");
		int slId = Integer.parseInt(sl_id);
		int result = slDao.deleteOneBysl_id(slId);
		arg1.getWriter().print(result);
		
	}

	/**
	 * ����songlist-detail.jsp�����������а����赥�ı��
	 * @param arg0	
	 * @param arg1
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doShowSongListDetail(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		
		String sl_isString = arg0.getParameter("sl_id");
		//�ø赥����
		int sl_id = Integer.parseInt(sl_isString);
		Songlist songlist = slservice.showDetailSonglist(sl_id);
		//���û��������赥
		int userId = songlist.getSl_userId();
		List<Songlist> songlists = slservice.findUserSongList(String.valueOf(userId));
		//�ø赥��������Ϣ
		List<SonglistComment> slComments = commentService.showAllSonglistComments(sl_id);
		arg0.setAttribute("songlist", songlist);
		arg0.setAttribute("songlists", songlists);
		arg0.setAttribute("comments", slComments);
		arg0.getRequestDispatcher("/jsp/songlist-detail.jsp").forward(arg0, arg1);
		
	}

	/**
	 * ����ǰ̨������һ��������ź�һ���赥��ţ�ɾ���ø赥�����׸���
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 */
	private void doRemoveSongFromSonglist(HttpServletRequest arg0,
			HttpServletResponse arg1) throws IOException {
		// ��������Ĳ���
		String s_id = arg0.getParameter("s_id");
		int songId = Integer.parseInt(s_id);
		String sl_id = arg0.getParameter("sl_id");
		int songlistId = Integer.parseInt(sl_id);
		int result = slwsDao.removeOne(songId,songlistId);
		//��ɾ���ɹ����������
		arg1.getWriter().println(result);
		
	}

	/**
	 * listen.jspҳ��  ��ȡ�û�songlistת����songservlet
	 * @param arg0
	 * @param arg1
	 */
	private void doShowUserSongList(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		
		String u_id = arg0.getParameter("u_id");
		List<Songlist> userSonglists = slservice.findUserSongList(u_id);
		//��ȡ�û��׸��赥��id
		Songlist firstSonglist = userSonglists.get(0);
		int sl_id = userSonglists.get(0).getSl_id();
		arg0.setAttribute("sl_id", sl_id);
		arg0.setAttribute("firstSonglist", firstSonglist);
		arg0.setAttribute("userSonglists", userSonglists);
		try {
			arg0.getRequestDispatcher("song?method=doShowUserSong").forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		};
		
	}

	/**
	 * ����ɾ��һ���ղظ赥������
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 */
	private void doDeleteCollectionSonglist(HttpServletRequest arg0,
			HttpServletResponse arg1) throws IOException {
		
		//��ȡ�������
		String sl_id = arg0.getParameter("sl_id");
		int slId = Integer.parseInt(sl_id);
		User user = (User) arg0.getSession().getAttribute("user");
		int result = slwuDao.deleteOne(slId,user.getU_id());
		arg1.getWriter().print(result);
		
	}

	/**
	 * ����songlist.jsp�����󣬽����ݷ�װ�ã�ת����songlist.jsp
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doShowTopSongList(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		
		List<Songlist> songlists = slservice.showTopCollectionSonglist();
		arg0.setAttribute("songlists", songlists);
		arg0.getRequestDispatcher("/jsp/songlist.jsp").forward(arg0, arg1);
		
	}
}

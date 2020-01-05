package com.mymusic.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mymusic.dao.SonglistDao;
import com.mymusic.dao.Impl.SonglistDaoImpl;
import com.mymusic.entity.Cd;
import com.mymusic.entity.PageBean;
import com.mymusic.entity.Song;
import com.mymusic.entity.Songlist;
import com.mymusic.entity.User;
import com.mymusic.service.CdService;
import com.mymusic.service.SongService;
import com.mymusic.service.SonglistService;
import com.mymusic.service.UserActionService;
import com.mymusic.service.Impl.CdServiceImpl;
import com.mymusic.service.Impl.SongServiceImpl;
import com.mymusic.service.Impl.SonglistServiceImpl;
import com.mymusic.service.Impl.UserActionServiceImpl;

/**
 * ���������й��û������� 
 *doLogout doUserLogin doUserRegister doShowMySonglist doShowSong
 * doUpdateSong doDeleteSong doAddSong
 */
@WebServlet("/user")
public class UserActionServlet extends HttpServlet {
	//����UserService
	private UserActionService userService = new UserActionServiceImpl();
	//����SongService
	private SongService songservice = new SongServiceImpl();
	//����CdService 
	private CdService cdService = new CdServiceImpl();
	//����SonglistService
	private SonglistService songlistService = new SonglistServiceImpl();
	private SonglistDao slDao = new SonglistDaoImpl();

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		String method = arg0.getParameter("method");

		if ("doLogout".equals(method)) {
			doLogout(arg0, arg1);
		}else if ("doUserLogin".equals(method)) {
			doUserLogin(arg0,arg1);
		}else if ("doUserRegister".equals(method)) {
			doUserRegister(arg0,arg1);
		}else if ("doShowMySonglist".equals(method)) {
			doShowMySonglist(arg0,arg1);
		}else if ("doAddLoveSongList".equals(method)) {
				doAddLoveSongList(arg0,arg1);
		}else if ("doShowSong".equals(method)) {
			doShowSong(arg0,arg1);
		}else if ("doUpdateSong".equals(method)) {
			doUpdateSong(arg0,arg1);
		}else if ("doDeleteSong".equals(method)) {
			doDeleteSong(arg0,arg1);
		}else if ("doAddSong".equals(method)) {
			doAddSong(arg0,arg1);
		}
		else {
			doShowIndex(arg0,arg1);
		}
	}

	private void doAddSong(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String s_name = arg0.getParameter("s_name");   //����
		String s_singername = arg0.getParameter("s_singername");   //����
		String spoken[] = arg0.getParameterValues("spoken");   //����   
	
		int n= songservice.addSong(s_name,s_singername,spoken);  //���Ӹ���
		
		arg0.setAttribute("n", n);
		arg0.getRequestDispatcher("/jsp/add.jsp").forward(arg0, arg1);
		
	}

	private void doDeleteSong(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException, ServletException {
		String s_id=arg0.getParameter("s_id");
		String page=arg0.getParameter("page");
		System.out.println(page);
		int page1=Integer.parseInt(page);
		int n=songservice.delSong(s_id);
		arg0.getRequestDispatcher("user?method=doShowSong&page="+page1).forward(arg0, arg1);
		
	}

	private void doUpdateSong(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException, ServletException {
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");		
		
		String s_id= arg0.getParameter("s_id");
		String s_name = arg0.getParameter("s_name");
		String s_singername = arg0.getParameter("s_singername");
		String spoken[] = arg0.getParameterValues("spoken");   
		
		int n=0;
		try {
			 n=songservice.updateSong(s_id, s_name, s_singername, spoken);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		String page=arg0.getParameter("page");
		int page1=Integer.parseInt(page);
		arg0.getRequestDispatcher("user?method=doShowSong&page="+page1).forward(arg0, arg1);
		
	}

	private void doShowSong(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		 String page= arg0.getParameter("page");  //���յ�ǰҳ��ҳ��
		    // page=null  page=1
		 PageBean pb = songservice.getPage(page, 10);//page����ǰҳ��10����һҳ��ʾ10��
			//ȥ��ʾ
		 arg0.setAttribute("pagebean", pb);       //�����������ֽ�pagebean������ֵΪpb
		// arg0.getRequestDispatcher("user?method=doShowSong&page=1").forward(arg0, arg1);//�ض���/jsp/show.jsp������request�������е�����
		 arg0.getRequestDispatcher("/jsp/show.jsp").forward(arg0, arg1);
	}

	/**
	 * ��ʾ��ҳ��
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doShowIndex(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		List<Cd> cds = cdService.showAllCds();
		List<Song> songs = songservice.showAllSongs();
		List<Song> orderSongs = songservice.showAllSongsOrderByPlay();
		List<Songlist> songlists = songlistService.showTopCollectionSonglist();
		arg0.setAttribute("cds", cds);
		arg0.setAttribute("songs", songs);
		arg0.setAttribute("orderSongs", orderSongs);
		arg0.setAttribute("songlists", songlists);
		arg0.getRequestDispatcher("jsp/index.jsp").forward(arg0, arg1);		
	}

	/**
	 * ������������ҵĸ赥ҳ��
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doShowMySonglist(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {		
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		List<Songlist> mysList = slDao.querySonglistsByUserId(user.getU_id());
		arg0.setAttribute("mysList", mysList);
		arg0.getRequestDispatcher("/jsp/my-songlist.jsp").forward(arg0, arg1);	
	}

	/**
	 * �û�ע�᷽�������գ��û��������룬�Ա���������
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doUserRegister(HttpServletRequest arg0,HttpServletResponse arg1) throws IOException, ServletException {
		String userName = arg0.getParameter("userName");
		String pwd = arg0.getParameter("pwd");
		String sex = arg0.getParameter("sex");
		int result = userService.doRegister(userName, pwd, sex);
		if (result==0) {
			arg0.setAttribute("fail", "ע��ʧ��");
			arg0.getRequestDispatcher("jsp/signup.jsp").forward(arg0, arg1);
		}else {
			arg0.setAttribute("success", "ע��ɹ���ȥ��½��");
			arg0.getRequestDispatcher("jsp/signup.jsp").forward(arg0, arg1);
		}		
	}

	/**
	 * �û���¼���������գ��û��������룩��������
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doUserLogin(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String userName = arg0.getParameter("userName");	//�û���
		String pwd = arg0.getParameter("pwd");	//����
		User user = userService.queryUser(userName, pwd);	
		int n=userService.queryUserType(userName, pwd);	
		if (n==0&&user==null) {
			//ת������¼ҳ��		
			arg0.setAttribute("result", "��¼ʧ��");
			arg0.getRequestDispatcher("jsp/signin.jsp").forward(arg0, arg1);
		}else if (n==2){
			arg0.getRequestDispatcher("user?method=doShowSong&page=1").forward(arg0, arg1);
	    	
		}
		else if (n==1){		   
			//session�����û�����
			HttpSession session = arg0.getSession();
			session.setAttribute("user", user);
			//ת������ҳ
			doShowIndex(arg0, arg1);
		}		
	}
	
	/**
	 * ��Ӹ������û��赥
	 * @param arg0
	 * @param arg1
	 */
	private void doAddLoveSongList(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		String sl_id = arg0.getParameter("selectsonglist");
		String s_id = arg0.getParameter("s_id");
		int result = userService.addSongToSongList(sl_id, s_id);
		arg0.setAttribute("result", result);
		try {
			arg0.getRequestDispatcher("song?method=doShowSongDetail&s_id="+s_id+"&result="+result).forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * �����û��˳���¼�ķ���
	 * @param arg0
	 * @param arg1
	 * @throws IOException 
	 */
	private void doLogout(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {
		//�����seseion
		HttpSession session = arg0.getSession();
		session.invalidate();
		//���¶��򵽵�¼ҳ
		arg1.sendRedirect("/mymusic/jsp/signin.jsp");
	}
}

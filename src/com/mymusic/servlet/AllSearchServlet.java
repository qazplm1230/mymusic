package com.mymusic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mymusic.dao.SongDao;
import com.mymusic.dao.Impl.SongDaoImpl;
import com.mymusic.dao.Impl.SonglistDaoImpl;
import com.mymusic.entity.SearchBean;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.service.SingerService;
import com.mymusic.service.SongService;
import com.mymusic.service.Impl.SingerServiceImpl;
import com.mymusic.service.Impl.SongServiceImpl;
/**
 * �������������servlet
 * doSerach   doSearchSongList
 *
 */
@WebServlet("/search")
public class AllSearchServlet extends HttpServlet{

	//����SongDao
	private SongService songService = new SongServiceImpl();
	//����SingerService
	private SingerService singerService = new SingerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		// �����������method��ֵ�ҵ�ƥ��ķ������������,�����ǿյ�
		// �ɴ�����������ȥ��д������,����д�÷���ע��
		String method = arg0.getParameter("method");
		
		if ("doSearch".equals(method)) {
			doSearch(arg0,arg1);
		}else if("doSearchSonglist".equals(method)){
			doSearchSonglist(arg0,arg1);
		}
		
	}

	private void doSearchSonglist(HttpServletRequest arg0,
			HttpServletResponse arg1) {
		
		
	}

	private void doSearch(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {

		//������Ӧ��ʽΪjson
		arg1.setContentType("application/json");
		//��ȡ�������
		String someName = arg0.getParameter("someName");
		//��ȡ����
		List<Song> songs = songService.showAjaxSongs(someName);
		List<Singer> singers = singerService.showAjaxSingers(someName);
		//��װ����
		SearchBean searchBean = new SearchBean();
		searchBean.setSongs(songs);
		searchBean.setSingers(singers);
		//������ת����json��ʽ�����ݷ��ͳ�ȥ
		Gson gson = new Gson();
		String data = gson.toJson(searchBean);
		arg1.getWriter().print(data);
		
	}
}

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
 * 处理各种搜索的servlet
 * doSerach   doSearchSongList
 *
 */
@WebServlet("/search")
public class AllSearchServlet extends HttpServlet{

	//声明SongDao
	private SongService songService = new SongServiceImpl();
	//声明SingerService
	private SingerService singerService = new SingerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		// 根据请求参数method的值找到匹配的方法处理该请求,方法是空的
		// 由处理该请求的人去编写方法体,并且写好方法注释
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

		//设置相应格式为json
		arg1.setContentType("application/json");
		//获取请求参数
		String someName = arg0.getParameter("someName");
		//获取数据
		List<Song> songs = songService.showAjaxSongs(someName);
		List<Singer> singers = singerService.showAjaxSingers(someName);
		//封装数据
		SearchBean searchBean = new SearchBean();
		searchBean.setSongs(songs);
		searchBean.setSingers(singers);
		//将数据转换成json格式的数据发送出去
		Gson gson = new Gson();
		String data = gson.toJson(searchBean);
		arg1.getWriter().print(data);
		
	}
}

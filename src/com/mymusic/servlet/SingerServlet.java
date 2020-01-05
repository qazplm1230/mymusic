package com.mymusic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mymusic.entity.Area;
import com.mymusic.entity.Cd;
import com.mymusic.entity.Singer;
import com.mymusic.entity.Song;
import com.mymusic.service.SingerService;
import com.mymusic.service.Impl.SingerServiceImpl;

/**
 * �������к͸�����ص����� 
 * doShowSingerDetail
 * 
 */
@WebServlet("/singer")
public class SingerServlet extends HttpServlet {

	private SingerService sgservice = new SingerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {

		// �����������method��ֵ�ҵ�ƥ��ķ������������,�����ǿյ�
		// �ɴ�����������ȥ��д������,����д�÷���ע��
		String method = arg0.getParameter("method");

		if ("doShowSingerDetail".equals(method)) {
			doShowSingerDetail(arg0, arg1);
		}
	}

	/**
	 * �����û���ţ���ת������ҳ��
	 * @param arg0
	 * @param arg1
	 */
	private void doShowSingerDetail(HttpServletRequest arg0,
			HttpServletResponse arg1) {

		String sg_id = arg0.getParameter("sg_id");
		Singer singer = sgservice.showOneSinger(sg_id);
		Area area = sgservice.showOneArea(sg_id);
		List<Cd> cds = sgservice.singerCds(sg_id);
		List<Song> songs = sgservice.singerSongs(sg_id); 
		arg0.setAttribute("singer", singer);
		arg0.setAttribute("area", area);
		arg0.setAttribute("cds", cds);
		arg0.setAttribute("songs", songs);
		try {
			arg0.getRequestDispatcher("jsp/singer.jsp").forward(arg0, arg1);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
package com.mymusic.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mymusic.entity.Cd;
import com.mymusic.service.CdService;
import com.mymusic.service.Impl.CdServiceImpl;
/**
 * 处理所有和专辑相关的请求
 * doShowNewCDS   doShowAllCD  doShowOneCD  doShowLikeCD
 *
 */
@WebServlet("/cd")
public class CdServlet extends HttpServlet{
	
	private CdService cdService = new CdServiceImpl();

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		// 根据请求参数method的值找到匹配的方法处理该请求,方法是空的
		// 由处理该请求的人去编写方法体,并且写好方法注释
		String method = arg0.getParameter("method");
		
		if ("doShowNewCDS".equals(method)) {
			doShowNewCDS(arg0, arg1);
		} else if ("doShowAllCD".equals(method)) {
			doShowAllCD(arg0, arg1);
		}else if ("doShowOneCD".equals(method)) {
			doShowOneCD(arg0,arg1);
		}else if ("doShowLikeCD".equals(method)) {
			doShowLikeCD(arg0,arg1);
		}
		
	}

	private void doShowLikeCD(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		int singerId = (int) arg0.getAttribute("sg_id");
		List<Cd> sameCds = cdService.showSameCds(singerId);
		arg0.setAttribute("sameCds", sameCds);
		arg0.getRequestDispatcher("/jsp/cd-detail.jsp").forward(arg0, arg1);	
	}

	private void doShowOneCD(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		
		String cid=arg0.getParameter("cid");
		int icid =Integer.parseInt(cid);
		Cd detailCD=cdService.getById(icid);
		arg0.setAttribute("detailCD", detailCD);
		arg0.setAttribute("sg_id", detailCD.getC_singerId());
		doShowLikeCD(arg0, arg1);
	}

	private void doShowAllCD(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		List<Cd> cds = cdService.getCDs();		
		arg0.setAttribute("cds",cds);
		arg0.getRequestDispatcher("/jsp/cd.jsp").forward(arg0, arg1);
		
	}

	private void doShowNewCDS(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		List<Cd> newCds = cdService.showNewCds();
		arg0.setAttribute("newCds", newCds);
		doShowAllCD(arg0, arg1);
	}
}

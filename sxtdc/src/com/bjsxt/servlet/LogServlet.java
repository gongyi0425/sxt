package com.bjsxt.servlet;



import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Log;
import com.bjsxt.service.LogService;
import com.bjsxt.service.impl.LogServiceImpl;


public class LogServlet extends BaseServlet {
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogService logservice = new LogServiceImpl();
		String starttime = null;
		String  endtime = null;
		List<Log> logList = logservice.getLogIntoDao(starttime, endtime);
		System.out.println(logList.size());
		if(logList.size()>0){
			request.setAttribute("logList", logList);
			request.getRequestDispatcher("/log.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "没有查到你要的信息");
			request.getRequestDispatcher("/log.jsp").forward(request, response);
		}
	}
		
	
}

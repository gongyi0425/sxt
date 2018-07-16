package com.bjsxt.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Announcement;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.AnnouncementService;
import com.bjsxt.service.impl.AnnouncementServiceImpl;
/**
 * 公告
 * @author zhujiaming
 *
 */
public class AnnouncementServlet extends BaseServlet {

	/**
	 * 添加公告
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addAnn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受视图层的表单信息
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String empid = emp.getEmpid();   //员工编号
		String anntheme = request.getParameter("anntheme");         //公告主题
		String anncontent = request.getParameter("anncontent");     //公告内容
		
		String sanntime = request.getParameter("anntime");          //公告时间
		String sannendtime = request.getParameter("annendtime");    //公告截止时间
		//变换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date anntime = null;
		try {
			anntime = df.parse(sanntime);//公告时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date annendtime = null;
		try {
			annendtime = df.parse(sannendtime);//公告截止时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Announcement ann = new Announcement(empid, anntheme, anncontent, anntime, annendtime);
		//调用业务层进行添加操作
		AnnouncementService annService = new AnnouncementServiceImpl();
		int n = annService.addAnn(ann);
		
		//跳转system/annList.jsp页面
		if(n > 0){
			//添加成功，跳转system/annList.jsp页面
			response.sendRedirect(request.getContextPath()+"/servlet/AnnouncementServlet?method=findAllAnn");
		}else{
			//添加失败，返回添加页面
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/system/addAdd.jsp").forward(request, response);
		}
	}
	/**
	 * 查询所有公告
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllAnn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用业务层查询所有公告信息
		AnnouncementService annService = new AnnouncementServiceImpl();
		List<Announcement> annList = annService.findAllAnn(null,null);
		
		//跳转到system/annList.jsp页面
		request.setAttribute("annList", annList);
		request.getRequestDispatcher("/system/annList.jsp").forward(request, response);
	}
	/**
	 * 查看所有公告
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findIdAnn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用业务层查询所有公告信息
		AnnouncementService annService = new AnnouncementServiceImpl();
		List<Announcement> annList = annService.findAllAnn(null,null);
		
		//跳转到system/annList.jsp页面
		request.setAttribute("annList", annList);
		request.getRequestDispatcher("/system/noticeList.jsp").forward(request, response);
	}
	/**
	 * 根据指定条件查询公告
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAnn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受查询条件
		String query = request.getParameter("query");
		String sdate = request.getParameter("date");
		//变换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(sdate);//公告时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		//调用业务层查询所有公告信息
		AnnouncementService annService = new AnnouncementServiceImpl();
		List<Announcement> annList = annService.findAllAnn(query,date);
		
		//跳转到system/annList.jsp页面
		request.setAttribute("query", query);
		request.setAttribute("annList", annList);
		request.getRequestDispatcher("/system/annList.jsp").forward(request, response);
	}
	/**
	 * 更新公告预查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findByIdAnn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取要更新的公告编号
		int annid = Integer.parseInt(request.getParameter("annid"));
		
		//调用业务层查询对应编号的公告信息
		AnnouncementService annService = new AnnouncementServiceImpl();
		Announcement ann = annService.findByIdAnn(annid);
		
		//跳转到member-add.jsp页面
		request.setAttribute("ann", ann);
		request.getRequestDispatcher("/system/member-add.jsp").forward(request, response);
	}
	/**
	 * 更新公告
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateAnn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取要更新的数据
		int annid = Integer.parseInt(request.getParameter("annid"));//公告编号
		String anntheme = request.getParameter("anntheme");         //公告主题
		String anncontent = request.getParameter("anncontent");     //公告内容
		String sanntime = request.getParameter("anntime");          //公告时间
		String sannendtime = request.getParameter("annendtime");    //公告截止时间
		//变换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date anntime = null;
		try {
			anntime = df.parse(sanntime);//公告时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date annendtime = null;
		try {
			annendtime = df.parse(sannendtime);//公告截止时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//调用业务层进行更新操作
		AnnouncementService annService = new AnnouncementServiceImpl();
		Announcement ann = new Announcement(annid, anntheme, anncontent, anntime, annendtime);
		int n = annService.updateAnn(ann);
		
		//跳转system/annList.jsp页面
		if(n > 0){
			//添加成功，跳转system/annList.jsp页面
			response.sendRedirect(request.getContextPath()+"/servlet/AnnouncementServlet?method=findAllAnn");
		}else{
			//添加失败，返回添加页面
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/system/member-add.jsp").forward(request, response);
		}
	}
	/**
	 * 删除公告
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteAnn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取要删除的公告编号
		int annid = Integer.parseInt(request.getParameter("annid"));//公告编号
		
		//调用业务层进行删除操作
		AnnouncementService annService = new AnnouncementServiceImpl();
		annService.deleteAnn(annid);
		
		//跳转system/annList.jsp页面
		response.sendRedirect(request.getContextPath()+"/servlet/AnnouncementServlet?method=findAllAnn");
	}
}

package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.CustomerSource;
import com.bjsxt.service.CustomerSourceService;
import com.bjsxt.service.impl.CustomerSourceServiceImpl;
/**
 * 客户来源
 * @author zhujiaming
 *
 */
public class CustomerSourceServlet extends BaseServlet {

	/**
	 * 添加客户来源
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取视图层的表单数据
		int souid = Integer.parseInt(request.getParameter("souid"));
		String souName = request.getParameter("souName");
		String souDesc = request.getParameter("souDesc");
		
		//调用业务层进行添加操作
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		CustomerSource source = new CustomerSource(souid, souName, souDesc);
		int n = sourceService.addSource(source);
		
		//跳转到customerSource.jsp页面
		if(n > 0){
			//添加成功，跳转到customerSource.jsp页面
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerSourceServlet?method=findAllSource");
		}else{
			//添加失败，返回添加页面
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/customer/customerSourceAdd.jsp").forward(request, response);
		}
	}
	/**
	 * 查询所有客户来源信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用业务层进行查询操作
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		List<CustomerSource> sourceList = sourceService.findAllSource();
		
		//跳转到customerSource.jsp页面
		request.setAttribute("sourceList", sourceList);
		request.getRequestDispatcher("/customer/customerSource.jsp").forward(request, response);
	}
	/**
	 * 更新客户来源信息预查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findByIdSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取要更新的客户来源编号
		int souid = Integer.parseInt(request.getParameter("souid"));
		
		//调用业务层进行更新操作
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		CustomerSource source = sourceService.findByIdSource(souid);
		
		//跳转到customerSourceUpdate.jsp页面
		request.setAttribute("source", source);
		request.getRequestDispatcher("/customer/customerSourceUpdate.jsp").forward(request, response);
	}
	/**
	 * 更新客户来源信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取视图层的表单信息
		int souid = Integer.parseInt(request.getParameter("souid"));
		String souName = request.getParameter("souName");
		String souDesc = request.getParameter("souDesc");
		
		//调用业务层进行更新操作
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		CustomerSource source = new CustomerSource(souid, souName, souDesc);
		int n = sourceService.updateSource(source);
		//跳转页面
		if(n > 0){
			//更新成功，跳转到customerSource.jsp页面
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerSourceServlet?method=findAllSource");
			
		}else{
			//更新失败，返回customerSource.jsp页面
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/servlet/CustomerSourceServlet?method=findAllSource").forward(request, response);
		}
	}
	/**
	 * 删除指定编号的客户来源信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受要删除的客户来源编号
		int souid = Integer.parseInt(request.getParameter("souid"));
		//调用业务层进行删除操作
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		sourceService.deleteSource(souid);
		
		//跳转customerSource.jsp页面
		response.sendRedirect(request.getContextPath()+"/servlet/CustomerSourceServlet?method=findAllSource");
	}
	/**
	 * 根据条件查询客户来源信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受查询条件
		String souName = request.getParameter("souName");
		
		//调用业务层查询指定的客户来源
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		List<CustomerSource> sourceList = sourceService.findSource(souName);
		
		//跳转到customerSource.jsp页面
		request.setAttribute("souName", souName);
		request.setAttribute("sourceList", sourceList);
		request.getRequestDispatcher("/customer/customerSource.jsp").forward(request, response);
		
	}
}

package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.CustomerSource;
import com.bjsxt.entity.CustomerStatus;
import com.bjsxt.service.CustomerSourceService;
import com.bjsxt.service.CustomerStatusService;
import com.bjsxt.service.impl.CustomerSourceServiceImpl;
import com.bjsxt.service.impl.CustomerStatusServiceImpl;
/**
 * 客户状态
 * @author ZhaoWeiguang
 *
 */
public class CustomerStatusServlet extends BaseServlet {

	/**
	 * 查询所有客户状态
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用业务层进行查询操作
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		List<CustomerStatus> statusList = statusService.findAllStatus();
		
		//跳转到customerSource.jsp页面
		request.setAttribute("statusList", statusList);
		request.getRequestDispatcher("/customer/customerState.jsp").forward(request, response);
	}
	/**
	 * 添加客户状态
	 * @param request
	 * @param response
	 * @throws ServletException 
	 * @throws IOException
	 */
	public void addStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取视图层的表单数据
		int staid = Integer.parseInt(request.getParameter("staid"));
		String staName = request.getParameter("staName");
		String staDesc = request.getParameter("staDesc");
		
		//调用业务层进行添加操作
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		CustomerStatus status = new CustomerStatus(staid, staName, staDesc);
		int n = statusService.addStatus(status);
		
		//跳转到customerStatus.jsp页面
		if(n > 0){
			//添加成功，跳转到customerStatus.jsp页面
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerStatusServlet?method=findAllStatus");
		}else{
			//添加失败，返回添加页面
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/customer/customerStateAdd.jsp").forward(request, response);
		}
	}
	/**
	 * 更新客户状态预查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findByIdStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取要更新的客户来源编号
		int staid = Integer.parseInt(request.getParameter("staid"));
		
		//调用业务层进行更新操作
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		CustomerStatus status = statusService.findByIdStatus(staid);
		
		//跳转到customerStatus.jsp页面
		request.setAttribute("status", status);
		request.getRequestDispatcher("/customer/customerStateUpdate.jsp").forward(request, response);
	}
	/**
	 * 更新客户状态
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取视图层的表单信息
		int staid = Integer.parseInt(request.getParameter("staid"));
		String staName = request.getParameter("staName");
		String staDesc = request.getParameter("staDesc");
		
		//调用业务层进行更新操作
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		CustomerStatus status = new CustomerStatus(staid, staName, staDesc);
		int n = statusService.updateStatus(status);
		//跳转页面
		if(n > 0){
			//更新成功，跳转到customerSource.jsp页面
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerStatusServlet?method=findAllStatus");
			
		}else{
			//更新失败，返回customerSource.jsp页面
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/servlet/CustomerStatusServlet?method=findAllStatus").forward(request, response);
		}
	}
	/**
	 * 删除指定编号的客户状态
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受要删除的客户状态编号
		int staid = Integer.parseInt(request.getParameter("staid"));
		//调用业务层进行删除操作
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		statusService.deleteStatus(staid);
		
		//跳转到customerSource.jsp页面
		request.getRequestDispatcher("/servlet/CustomerStatusServlet?method=findAllStatus").forward(request, response);
	}
	/**
	 * 根据条件查询客户来源信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受查询条件
		String staName = request.getParameter("staName");
		
		//调用业务层查询指定的客户来源
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		List<CustomerStatus> statusList = statusService.findStatus(staName);
		
		//跳转到customerSource.jsp页面
		request.setAttribute("staName", staName);
		request.setAttribute("statusList", statusList);
		request.getRequestDispatcher("/customer/customerState.jsp").forward(request, response);
		
	}
}

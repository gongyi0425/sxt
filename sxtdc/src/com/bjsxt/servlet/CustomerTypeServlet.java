package com.bjsxt.servlet;
/*
 * 潘培轩
 */
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.CustomerType;
import com.bjsxt.entity.Department;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.CustomerTypeService;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.impl.CustomerTypeServiceImpl;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.bjsxt.service.impl.EmployeeServiceImpl;
/**
 * 客户类型
 * @author ZhaoWeiguang
 *
 */
public class CustomerTypeServlet extends BaseServlet {

	/*
	 * 添加客户类型
	 */
	public void addCustomerType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取添加客户类型表单的数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		String typeName = request.getParameter("typeName");
		String typeDesc = request.getParameter("typeDesc");
		//调用业务层完成添加客户类型的操作
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		CustomerType customerType = new CustomerType(typeid, typeName, typeDesc);
		int n = customerTypeService.addCustomerType(customerType);
		//跳转到客户类型页面：customerType.jsp
		if (n > 0) {
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerTypeServlet?method=findAllCustomerType");
		} else {
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/customer/customerTypeAdd.jsp").forward(request, response);
		}
	}
	
	/*
	 * 查询所有客户类型
	 */
	public void findAllCustomerType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		
		//调用业务层完成查询操作
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
		//根据结果调转到相应的页面
		request.setAttribute("customerTypeList", customerTypeList);
		request.getRequestDispatcher("/customer/customerType.jsp").forward(request, response);
	}
	
	/*
	 * 按条件查询客户类型(查询所有是按条件查询的一种特殊情况)
	 */
	public void findCustomerType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收查询数据
		String typeName = request.getParameter("typeName");
		//调用业务层完成查询操作
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		List<CustomerType> customerTypeList = customerTypeService.findCustomerType(typeName);
		//跳转到相应的页面
		request.setAttribute("typeName", typeName);
		request.setAttribute("customerTypeList", customerTypeList);
		request.getRequestDispatcher("/customer/customerType.jsp").forward(request, response);
	}
	
	/*
	 * 删除客户类型
	 */
	public void deleteCustomerType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		//调用业务层完成删除操作
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		customerTypeService.deleteCustomerType(typeid);
		//根据结果调转到相应的页面
		request.getRequestDispatcher("/servlet/CustomerTypeServlet?method=findAllCustomerType").forward(request, response);
	}
	
	/*
	 * 更新指定编号的客户类型
	 */
	public void findCustomerTypeById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		//调用业务层完成查询指定编号的操作
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		CustomerType customerType = customerTypeService.findCustomerTypeById(typeid);
		//根据结果调转到相应的页面
		request.setAttribute("customerType", customerType);
		request.getRequestDispatcher("/customer/customerTypeUpdate.jsp").forward(request, response);
	}
	
	/*
	 * 更新客户类型
	 */
	public void updateCustomerType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		String typeName = request.getParameter("typeName");
		String typeDesc = request.getParameter("typeDesc");
		//调用业务层完成更新操作
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		CustomerType customerType = new CustomerType(typeid, typeName, typeDesc);
		int n = customerTypeService.updateCustomerType(customerType);
		//根据结果调转到相应的页面
		if(n > 0){
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerTypeServlet?method=findAllCustomerType");
		}else{
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/customer/customerTypeUpdate.jsp").forward(request, response);
		}
	}	
}

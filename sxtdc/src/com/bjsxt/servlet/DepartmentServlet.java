package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Department;

import com.bjsxt.service.DepartmentService;

import com.bjsxt.service.impl.DepartmentServiceImpl;

/**
 * 部门
 * @author ZhaoWeiguang
 *
 */
public class DepartmentServlet extends BaseServlet {

	
	/**
	 * 添加部门信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取视图层的表单信息
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String deptName = request.getParameter("deptName");
		String location = request.getParameter("location");
		String deptDesc = request.getParameter("deptDesc");
		
		//调用业务层进行添加操作
		DepartmentService deptService = new DepartmentServiceImpl();
		Department dept = new Department(deptno, deptName, deptDesc, location);
		int n = deptService.addDept(dept);
		
		//跳转页面
		if(n > 0){
			//添加成功，跳转到部门管理页面
			response.sendRedirect(request.getContextPath()+"/servlet/DepartmentServlet?method=findAllDept");
			
		}else{
			//添加失败，返回添加页面
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/system/deptAdd.jsp").forward(request, response);
		}
	}
	/**
	 * 查询部门信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用业务层进行查询操作
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAllDept();
		
		//跳转system/deptList.jsp页面
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/system/deptList.jsp").forward(request, response);
	}
	/**
	 * 更新部门预查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findByIdDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受要更新的部门编号
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		//调用业务层进行预查询操作
		DepartmentService deptService = new DepartmentServiceImpl();
		Department dept = deptService.findByIdDept(deptno);
		
		//跳转system/deptList.jsp页面
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("/system/deptUpdate.jsp").forward(request, response);
	}
	/**
	 * 更新部门信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取视图层的表单信息
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String deptName = request.getParameter("deptName");
		String location = request.getParameter("location");
		String deptDesc = request.getParameter("deptDesc");
		
		//调用业务层进行更新操作
		DepartmentService deptService = new DepartmentServiceImpl();
		Department dept = new Department(deptno, deptName, deptDesc, location);
		int n = deptService.updateDept(dept);
		
		//跳转页面
		if(n > 0){
			//添加成功，跳转到部门管理页面
			response.sendRedirect(request.getContextPath()+"/servlet/DepartmentServlet?method=findAllDept");
			
		}else{
			//添加失败，返回部门管理页面
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/servlet/DepartmentServlet?method=findAllDept").forward(request, response);
		}
	}
	/**
	 * 删除指定编号的部门信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受要删除的部门编号
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		//调用业务层进行删除操作
		DepartmentService deptService = new DepartmentServiceImpl();
		deptService.deleteDept(deptno);
		
		//跳转system/deptList.jsp页面
		response.sendRedirect(request.getContextPath()+"/servlet/DepartmentServlet?method=findAllDept");
	}
}

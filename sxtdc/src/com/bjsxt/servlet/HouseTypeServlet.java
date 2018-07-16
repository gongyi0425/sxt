package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.HouseType;
import com.bjsxt.service.HouseTypeService;
import com.bjsxt.service.impl.HouseTypeServiceImpl;
/**
 * 房屋类型
 * @author 潘培轩
 *
 */
public class HouseTypeServlet extends BaseServlet {

	/*
	 * 添加房屋类型
	 */
	public void addHouseType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取添加房屋类型表单的数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		String typeName = request.getParameter("typeName");
		String typeDesc = request.getParameter("typeDesc");
		//调用业务层完成添加房屋类型的操作
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		HouseType houseType = new HouseType(typeid, typeName, typeDesc);
		int n = houseTypeService.addHouseType(houseType);
		//跳转到房屋类型页面：houseType.jsp
		if (n > 0) {
			response.sendRedirect(request.getContextPath()+"/servlet/HouseTypeServlet?method=findAllHouseType");
		} else {
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/house/houseTypeAdd.jsp").forward(request, response);
		}
	}
	
	/*
	 * 查询所有房屋类型
	 */
	public void findAllHouseType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		
		//调用业务层完成查询操作
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		List<HouseType> houseTypeList = houseTypeService.findAllHouseType();
		//根据结果调转到相应的页面
		request.setAttribute("houseTypeList", houseTypeList);
		request.getRequestDispatcher("/house/houseType.jsp").forward(request, response);
	}
	
	/*
	 * 按条件查询房屋类型(查询所有是按条件查询的一种特殊情况)
	 */
	public void findHouseType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收查询数据
		String typeName = request.getParameter("typeName");
		//调用业务层完成查询操作
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		List<HouseType> houseTypeList = houseTypeService.findHouseType(typeName);
		//跳转到相应的页面
		request.setAttribute("typeName", typeName);
		request.setAttribute("houseTypeList", houseTypeList);
		request.getRequestDispatcher("/house/houseType.jsp").forward(request, response);
	}
	
	/*
	 * 删除房屋类型
	 */
	public void deleteHouseType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		//调用业务层完成删除操作
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		houseTypeService.deleteHouseType(typeid);
		//根据结果调转到相应的页面
		request.getRequestDispatcher("/house/houseType.jsp").forward(request, response);
	}
	
	/*
	 * 查询指定编号的房屋类型
	 */
	public void findHouseTypeById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		//调用业务层完成查询指定编号的操作
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		HouseType houseType = houseTypeService.findHouseTypeById(typeid);
		//根据结果调转到相应的页面
		request.setAttribute("houseType", houseType);
		request.getRequestDispatcher("/house/houseTypeUpdate.jsp").forward(request, response);
	}
	
	/*
	 * 更新房屋类型
	 */
	public void updateHouseType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		String typeName = request.getParameter("typeName");
		String typeDesc = request.getParameter("typeDesc");
		//调用业务层完成更新操作
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		HouseType houseType = new HouseType(typeid, typeName, typeDesc);
		int n = houseTypeService.updateHouseType(houseType);
		//根据结果调转到相应的页面
		if(n > 0){
			response.sendRedirect(request.getContextPath()+"/servlet/HouseTypeServlet?method=findAllHouseType");
		}else{
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/house/houseTypeUpdate.jsp").forward(request, response);
		}
	}

}

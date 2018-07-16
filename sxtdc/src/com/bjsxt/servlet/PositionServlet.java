package com.bjsxt.servlet;
/*
 * 潘培轩
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Position;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.PositionServiceImpl;

public class PositionServlet extends BaseServlet {

	/*
	 * 添加岗位
	 */
	public void addPos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取添加岗位表单的数据
		int posid = Integer.parseInt(request.getParameter("posid"));
		String posName = request.getParameter("posName");
		String posDesc = request.getParameter("posDesc");
		//调用业务层完成添加岗位的操作
		PositionService posService = new PositionServiceImpl();
		Position position = new Position(posid, posName, posDesc);
		int n = posService.addPos(position);
		//跳转到岗位管理页面：posList.jsp
		if (n > 0) {
			response.sendRedirect(request.getContextPath()+"/servlet/PositionServlet?method=findAllPos");
		} else {
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/system/posAdd.jsp").forward(request, response);
		}
	}
	
	/*
	 * 查询所有岗位信息
	 */
	public void findAllPos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		
		//调用业务层完成查询操作
		PositionService positionService = new PositionServiceImpl();
		List<Position> positionList = positionService.findAllPos();
		//根据结果调转到相应的页面
		request.setAttribute("positionList", positionList);
		request.getRequestDispatcher("/system/posList.jsp").forward(request, response);
	}
	
	/*
	 * 删除岗位
	 */
	public void deletePos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int posid = Integer.parseInt(request.getParameter("posid"));
		//调用业务层完成删除操作
		PositionService positionService = new PositionServiceImpl();
		positionService.deletePos(posid);
		//根据结果调转到相应的页面
		request.getRequestDispatcher("/servlet/PositionServlet?method=findAllPos").forward(request, response);
	}
	
	/*
	 * 查询指定编号的岗位
	 */
	public void findPosById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int posid = Integer.parseInt(request.getParameter("posid"));
		//调用业务层完成查询指定编号的操作
		PositionService positionService = new PositionServiceImpl();
		Position position = positionService.findPosById(posid);
		//根据结果调转到相应的页面
		request.setAttribute("position", position);
		request.getRequestDispatcher("/system/posUpdate.jsp").forward(request, response);
	}
	
	/*
	 * 更新岗位
	 */
	public void updatePos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int posid = Integer.parseInt(request.getParameter("posid"));
		String posName = request.getParameter("posName");
		String posDesc = request.getParameter("posDesc");
		//调用业务层完成更新操作
		PositionService positionService = new PositionServiceImpl();
		Position position = new Position(posid, posName, posDesc);
		int n = positionService.updatePos(position);
		//根据结果调转到相应的页面
		if(n > 0){
			response.sendRedirect(request.getContextPath()+"/servlet/PositionServlet?method=findAllPos");
		}else{
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/system/posUpdate.jsp").forward(request, response);
		}
	}	

}

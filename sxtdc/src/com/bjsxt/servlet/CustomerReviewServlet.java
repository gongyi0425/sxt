package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.CustomerReview;
import com.bjsxt.service.CustomerReviewService;
import com.bjsxt.service.impl.CustomerReviewServiceImpl;

public class CustomerReviewServlet extends BaseServlet{
	/**
	 * 添加客户回访信息
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void addReview(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		//获取视图层的表单数据
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String reviewName = request.getParameter("reviewName");
		String reviewDesc = request.getParameter("reviewDesc");
		//调用业务层进行创建操作
		CustomerReviewService reviewService = new CustomerReviewServiceImpl();
		CustomerReview review = new CustomerReview(reviewId,reviewName,reviewDesc);
		int n = reviewService.addReview(review);
		//跳转到customerReview.jsp页面
		if(n>0){
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerReviewServlet?method=findAllReview");
		}else{
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/customer/customerReviewAdd.jsp").forward(request, response);
		}
	}
	/**
	 * 更新客户回复信息
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void updateReview(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		//获取师徒层的表单数据
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String reviewName = request.getParameter("reviewName");
		String reviewDesc = request.getParameter("reviewDesc");
		//调用业务层进行更新操作
		CustomerReviewService reviewService = new CustomerReviewServiceImpl();
		CustomerReview review = new CustomerReview(reviewId,reviewName,reviewDesc);
		int n = reviewService.addReview(review);
		//跳转到customerReview.jsp页面
		if(n>0){
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerReviewServlet?method=findAllReview");
		} else{
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/servlet/CustomerReviewServlet?method=findAllReview").forward(request, response);
		}
	}
	/**
	 * 删除指定编号的客户回访信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void deleteReview(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//获取要删除的客户回访信息对应的id
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		//调用业务层的方法删除客户回访信息
		CustomerReviewService reviewService = new CustomerReviewServiceImpl();
		reviewService.deleteReview(reviewId);
		//跳转到customerReview.jsp页面
		response.sendRedirect(request.getContextPath()+"servlet/CustomerReviewServlet?method=findAllReview");
	}
	/**
	 * 根据条件查询客户回访信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findReview(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//获取查询条件
		String reviewName = request.getParameter("reviewName");
		//调用业务层的方法查询客户的回访信息
		CustomerReviewService reviewService = new CustomerReviewServiceImpl();
		List<CustomerReview> reviewList = reviewService.findReview(reviewName);
		request.setAttribute("reviewName", reviewName);
		request.setAttribute("reviewList", reviewList);
		request.getRequestDispatcher("/customer/customerReview.jsp").forward(request, response);
	}
	/**
	 * 查询所有客户回访的信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllReview(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//调用业务层方法查询所有客户回访信息
		CustomerReviewService reviewService = new CustomerReviewServiceImpl();
		List<CustomerReview> reviewList = reviewService.findAllReview();
		//跳转到customerReview.jsp页面
		request.setAttribute("reviewList", reviewList);
		request.getRequestDispatcher("/customer/customerReview.jsp").forward(request, response);
	}
	
}

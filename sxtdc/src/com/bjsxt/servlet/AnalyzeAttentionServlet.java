package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.service.AnalyzeAttentionService;
import com.bjsxt.service.impl.AnalyzeAttentionServiceImpl;


import net.sf.json.JSONArray;

public class AnalyzeAttentionServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		
		//从数据库里取数据
		AnalyzeAttentionService attentionService = new AnalyzeAttentionServiceImpl();
		String attentionArr = attentionService.analyzeAttention();
		
		//设置服务器响应时向JSP表示层传输数据的编码格式
		resp.setContentType("text/html; charset=utf-8");
		//ArrayList对象转化为JSON对象

		System.out.println(attentionArr);
		//ArrayList对象转化为JSON对象
		JSONArray json = JSONArray.fromObject(attentionArr);
		//控制台显示JSON
		System.out.println(json.toString());
		
		//返回到JSP
		PrintWriter writer = resp.getWriter();
		writer.println(json);
		writer.flush();
		//关闭输出流
		writer.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}

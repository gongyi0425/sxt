package com.bjsxt.listener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.bjsxt.entity.Log;
import com.bjsxt.service.LogService;
import com.bjsxt.service.impl.LogServiceImpl;

/**
 * 在web.xml中配置该文件---------------------------------------
 * @author Administrator
 *
 */

public class EmpListener implements ServletContextListener,HttpSessionListener{
	//服务器关闭时，保存count值
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		//获取servletcontext对象
			ServletContext sc = sce.getServletContext();
		//将计数器从servletcontext作用域中读取出来
			int count = (Integer) sc.getAttribute("count");
		//创建service对象
			LogService  ls = new LogServiceImpl();
		//调用service对象中的方法，将计数器存储到数据库中
			ls.setCountIntoDao(count);
		//测试数据
			//System.out.println("EmpListener.contextDestroyed()"+count);
		
	}
	//服务器启动时，读取count值
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建service对象--获取计数器
		LogService  ls = new LogServiceImpl();	
		//调用service方法，获取count值
		int count = ls.getCountIntoDao();
		//创建servletcontext对象
		ServletContext sc = sce.getServletContext();	
		//将计数器存储到servletcontext作用域中
		sc.setAttribute("count", count);
		//测试数据 
		//System.out.println("EmpListener.contextInitialized()"+count);
		
	}
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		// 当session被创建的时候，保存---登录时间--用户名---用户ip
		//创建Log对象
		
		//最后将Log对象放入到session对象中
			
		//测试数据
			//System.out.println("EmpListener.sessionCreated()"+log);
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		// 当session被创建的时候，保存---注册时间
		//将Log对象从session作用域中读取下来
			Log log = (Log) hse.getSession().getAttribute("Log");
		//获取endtime
			Date endtime = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String eTime = null;
			eTime = df.format(endtime);
		//设置endtime
			log.setEndtime(eTime);
		//将Log对象存储到数据库中
			//创建service对象
				LogService  ls = new LogServiceImpl();
			//调用service对象中的方法，将计数器存储到数据库中
				ls.setLogIntoDao(log);
			//测试数据
				//System.out.println("EmpListener.sessionDestroyed()"+log);
	}
	
}

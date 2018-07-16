package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.LogDao;
import com.bjsxt.entity.Log;
import com.bjsxt.util.DBUtil;

public class LogDaoImpl implements LogDao {

	@Override
	public void setCountIntoData(int c) {
		//创建SQL命令
			String sql = "update cnumber  set count =?";
		//给占位符赋值
			Object[] params = {c};
		//执行
			DBUtil.executeUpdate(sql, params);
		
	}

	@Override
	public int getCountIntoData() {
		//1.创建jdbc变量
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		//2.创建变量
			int count = 0;
		try {
			//3.获取连接			
				conn =DBUtil.getConnection();
			//4.创建sql命令
				String sql = "select * from cnumber";
			//4.创建SQL命令发送器
				pstmt = conn.prepareStatement(sql);
			//5.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
				rs = pstmt.executeQuery();
			
			//6.遍历--处理结果
				rs.next();
				count = rs.getInt(2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//测试代码
			System.out.println("LogDaoImpl.getCountIntoData()"+count);
		//8.返回数据	
			return count;
	}

	@Override
	public void setLogIntoData(Log log) {
		// 保存日志到数据库----------------------------------------------------------------
		//创建sql命令
			String sql = "insert into log(logid,empid,cip,starttime,endtime)  values(?,?,?,?,?)";
		//给占位符赋值
			Object[] params = {log.getLogid(),log.getEmpid(),log.getCip(),log.getStarttime(),log.getEndtime()};
		//执行	
			DBUtil.executeUpdate(sql, params);
	}

	@Override
	public List<Log> getLogIntoData(String starttime,String endtime) {
		//1.声明jdbc变量
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		//2.声明变量
			List<Log> al = null;
		try {
			//3.获取连接			
				conn =DBUtil.getConnection();
			//4.创建sql命令
				String sql = "select * from log";//where starttime between ? and ?
			//5.创建SQL命令发送器
				pstmt = conn.prepareStatement(sql);
			//6.给占位符赋值
//				pstmt.setDate(1, (java.sql.Date) starttime);
//				pstmt.setDate(2, (java.sql.Date) endtime);
			//7.执行
				rs = pstmt.executeQuery();
				
				al = new ArrayList<Log>();
			//8.遍历
				while(rs.next()){
					//创建log对象
						Log log = new Log();
					//赋值
						log.setLogid(rs.getInt("logid"));
						log.setEmpid(rs.getString("empid"));
						log.setCip(rs.getString("cip"));
						log.setStarttime(rs.getString("starttime"));
						log.setEndtime(rs.getString("endtime"));
					//测试数据
						log.toString();
					//给集合中添加类
						al.add(log);
					
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//测试数据
			System.out.println("LogDaoImpl.getLogIntoData()"+al);
		//7.返回数据	
			return al;
	}

}

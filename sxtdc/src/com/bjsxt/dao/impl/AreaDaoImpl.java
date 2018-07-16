package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.AreaDao;
import com.bjsxt.entity.Area;
import com.bjsxt.util.DBUtil;

public class AreaDaoImpl implements AreaDao {

	/**
	 * 根据编号获得区域信息
	 */
	public List<Area> findAreaById(int pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//创建一个list集合
		List<Area> areaList = new ArrayList<Area>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from area where parentid=?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int areaID = rs.getInt("areaid");
				String areaName = rs.getString("areaname");
				int parentID= rs.getInt("parentid");
				
				Area area = new Area(areaID, areaName, parentID);
				 areaList.add(area);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return areaList;
	}

	/**
	 * 根据  省  市  县 的编号 获得对应的名称
	 */
	public String findAreaName(int areaid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//创建一个list集合
		String areaName = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from area where areaid=?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			pstmt.setInt(1, areaid);
			rs = pstmt.executeQuery();
			
			//5.处理结果
			rs.next();
			
			areaName = rs.getString("areaname");

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return areaName;
	}

	/**
	 * 客户分布图显示
	 */
	public String getAreaData() {
		// TODO Auto-generated method stub
		return null;
	}

}

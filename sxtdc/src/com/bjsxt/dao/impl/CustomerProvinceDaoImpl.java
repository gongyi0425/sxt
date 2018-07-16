package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.CustomerProvinceDao;
import com.bjsxt.entity.Province;
import com.bjsxt.util.DBUtil;
import com.google.gson.Gson;



public class CustomerProvinceDaoImpl implements CustomerProvinceDao{
	@Override
	public String countProvince() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Province> provinList = new ArrayList<Province>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select PROVINCE,count(*) as ProNum from CUSTOMER group by PROVINCE");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()) {
				Province province = new Province();
				province.setName(rs.getString("PROVINCE"));
				province.setNum(rs.getInt("ProNum"));
				provinList.add(province);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		Gson gson =new Gson();
		String str=gson.toJson(provinList);
		return str;
		
	}
		
	
}

package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.HouseTypeDao;
import com.bjsxt.entity.HouseType;
import com.bjsxt.util.DBUtil;

/**
 * 房屋类型
 * @author 潘培轩
 *
 */
public class HouseTypeDaoImpl implements HouseTypeDao{

	/*
	 * 添加房屋类型
	 */
	@Override
	public int save(HouseType houseType) {
		String sql = "insert into housetype values(?,?,?)";
		Object[] params = {houseType.getTypeid(),houseType.getTypeName(),houseType.getTypeDesc()};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询所有房屋类型
	 */
	@Override
	public List<HouseType> findAllHouseType() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseType> houseTypeList = new ArrayList<HouseType>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from housetype");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int typeid = rs.getInt("typeid");
				String typeName = rs.getString("typeName");
				String typeDesc = rs.getString("typedesc");
				//2.将当前行各个字段的值封装到Employee对象中
				HouseType houseType = new HouseType(typeid, typeName, typeDesc);
				//3.将user放入userList
				houseTypeList.add(houseType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return houseTypeList;
	}

	/*
	 * 按条件查询房屋类型(查询所有是按条件查询的一种特殊情况)
	 */
	@Override
	public List<HouseType> findHouseType(String typeName2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseType> houseTypeList = new ArrayList<HouseType>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder("select * from housetype h where 1=1");
			if(typeName2 != null && !"".equals(typeName2)){
				sql.append(" and h.typeName like '%"+typeName2+"%'");
			}
			pstmt = conn.prepareStatement(sql.toString());
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int typeid = rs.getInt("typeid");
				String typeName = rs.getString("typeName");
				String typeDesc = rs.getString("typedesc");
				//2.将当前行各个字段的值封装到Employee对象中
				HouseType houseType = new HouseType(typeid, typeName, typeDesc);
				//3.将user放入userList
				houseTypeList.add(houseType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return houseTypeList;
	}

	/*
	 * 删除房屋类型
	 */
	@Override
	public int deleteHouseType(int typeid) {
		String sql = "delete from housetype where typeid = ?";
		Object[] params = {typeid};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询指定编号的房屋类型
	 */
	@Override
	public HouseType findHouseTypeById(int typeid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HouseType houseType = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from housetype where typeid = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）	
			pstmt.setInt(1, typeid);
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			if(rs.next()){
				//1.取出当前行各个字段的值
				String typeName = rs.getString("typeName");
				String typeDesc = rs.getString("typedesc");
				//2.将当前行各个字段的值封装到Employee对象中
				houseType = new HouseType(typeid, typeName, typeDesc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return houseType;
	}

	/*
	 * 更新房屋类型
	 */
	@Override
	public int updateHouseType(HouseType houseType) {
		String sql = "update housetype set typeName = ?,typeDesc = ? where typeid = ?";
		Object[] params = {houseType.getTypeName(),houseType.getTypeDesc(),houseType.getTypeid()};
		return DBUtil.executeUpdate(sql, params);
	}
	

}

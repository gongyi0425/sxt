package com.bjsxt.dao.impl;
/*
 * 潘培轩
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.CustomerTypeDao;
import com.bjsxt.entity.CustomerType;
import com.bjsxt.util.DBUtil;
/**
 * 客户类型  dao  层实现类
 * @author 潘培轩
 *
 */
public class CustomerTypeDaoImpl implements CustomerTypeDao{

	/*
	 * 添加客户类型
	 */
	@Override
	public int saveCustomerType(CustomerType customerType) {
		String sql = "insert into customertype values(?,?,?)";
		Object[] params = {customerType.getTypeid(),customerType.getTypeName(),customerType.getTypeDesc()};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询所有客户类型
	 */
	@Override
	public List<CustomerType> findAllCustomerType() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerType> customerTypeList = new ArrayList<CustomerType>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from customertype");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int typeid = rs.getInt("typeid");
				String typeName = rs.getString("typeName");
				String typeDesc = rs.getString("typedesc");
				//2.将当前行各个字段的值封装到Employee对象中
				CustomerType customerType = new CustomerType(typeid, typeName, typeDesc);
				//3.将user放入userList
				customerTypeList.add(customerType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return customerTypeList;
	}

	/*
	 * 删除客户类型
	 */
	@Override
	public int deleteCustomerType(int typeid) {
		String sql = "delete from customertype where typeid = ?";
		Object[] params = {typeid};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询指定编号的客户类型
	 */
	@Override
	public CustomerType findCustomerTypeById(int typeid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerType customerType = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from customertype where typeid = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）	
			pstmt.setInt(1, typeid);
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			if(rs.next()){
				//1.取出当前行各个字段的值
				String typeName = rs.getString("typeName");
				String typeDesc = rs.getString("typedesc");
				//2.将当前行各个字段的值封装到Employee对象中
				customerType = new CustomerType(typeid, typeName, typeDesc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return customerType;
	}

	/*
	 * 更新客户类型
	 */
	@Override
	public int updateCustomerType(CustomerType customerType) {
		String sql = "update customertype set typeName = ?,typeDesc = ? where typeid = ?";
		Object[] params = {customerType.getTypeName(),customerType.getTypeDesc(),customerType.getTypeid()};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 按条件查询客户类型(查询所有是按条件查询的一种特殊情况)
	 */
	@Override
	public List<CustomerType> findCustomerType(String typeName2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerType> customerTypeList = new ArrayList<CustomerType>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder("select * from customertype c where 1=1");
			if(typeName2 != null && !"".equals(typeName2)){
				sql.append(" and c.typeName like '%"+typeName2+"%'");
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
				CustomerType customerType = new CustomerType(typeid, typeName, typeDesc);
				//3.将user放入userList
				customerTypeList.add(customerType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return customerTypeList;
	}

}

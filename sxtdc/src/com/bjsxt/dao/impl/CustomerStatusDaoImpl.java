package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.CustomerStatusDao;
import com.bjsxt.entity.CustomerStatus;
import com.bjsxt.util.DBUtil;

/**
 * 客户状态
 * @author 无情
 *
 */
public class CustomerStatusDaoImpl implements CustomerStatusDao{

	/**
	 * 添加客户状态
	 */
	@Override
	public int addStatus(CustomerStatus status) {
		String sql = "insert into CustomerStatus values(?,?,?)";
		Object [] params = {status.getStaid(),status.getStaName(),status.getStaDesc()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 更新客户状态
	 */
	@Override
	public int updateStatus(CustomerStatus status) {
		String sql = "update CustomerStatus set staName=?,staDesc=? where staid= ?";
		Object [] params = {status.getStaName(),status.getStaDesc(),status.getStaid()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 删除指定编号的客户状态
	 */
	@Override
	public int deleteStatus(int staid) {
		String sql = "delete from CustomerStatus where staid = ?";
		Object [] params = {staid};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 查询所有客户状态
	 */
	@Override
	public List<CustomerStatus> findAllStatus() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerStatus> statusList = new ArrayList<CustomerStatus>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from CustomerStatus");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int staid = rs.getInt("staid");
				String staName = rs.getString("staName");
				String staDesc = rs.getString("staDesc");
				//2.将当前行各个字段的值封装到Employee对象中
				CustomerStatus status = new CustomerStatus(staid, staName, staDesc);
				//3.将user放入userList
				statusList.add(status);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return statusList;
	}
	/**
	 * 更新客户状态预查询
	 */
	@Override
	public CustomerStatus findByIdStatus(int staid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerStatus status = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from CustomerStatus where staid = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）	
			pstmt.setInt(1, staid);
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			if(rs.next()){
				//1.取出当前行各个字段的值
				String staName = rs.getString("staName");
				String staDesc = rs.getString("staDesc");
				//2.将当前行各个字段的值封装到Employee对象中
				status = new CustomerStatus(staid, staName, staDesc);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return status;
	}
	/**
	 * 查询指定编号的客户状态
	 */
	@Override
	public List<CustomerStatus> findStatus(String staName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerStatus> statusList = new ArrayList<CustomerStatus>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from CustomerStatus where staName = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			pstmt.setString(1, staName);
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int staid = rs.getInt("staid");
				String staDesc = rs.getString("staDesc");
				//2.将当前行各个字段的值封装到Employee对象中
				CustomerStatus status = new CustomerStatus(staid, staName, staDesc);
				//3.将user放入userList
				statusList.add(status);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return statusList;
	}
}

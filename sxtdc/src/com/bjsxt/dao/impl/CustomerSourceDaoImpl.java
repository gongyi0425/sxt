package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.CustomerSourceDao;
import com.bjsxt.entity.CustomerSource;
import com.bjsxt.util.DBUtil;

/**
 * 客户来源  dao层  实现类
 * @author ZhaoWeiguang
 *
 */
public class CustomerSourceDaoImpl implements CustomerSourceDao {

	/**
	 * 添加客户来源
	 */
	@Override
	public int addSource(CustomerSource source) {
		String sql = "insert into customersource values(?,?,?)";
		Object [] params = {source.getSouid(),source.getSouName(),source.getSouDesc()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 更新客户来源信息
	 */
	@Override
	public int updateSource(CustomerSource source) {
		String sql = "update customersource set souName=?,soudesc=? where souid= ?";
		Object [] params = {source.getSouName(),source.getSouDesc(),source.getSouid()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 删除指定编号的客户来源信息
	 */
	@Override
	public int deleteSource(int souid) {
		String sql = "delete from customersource where souid = ?";
		Object [] params = {souid};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 查询所有客户来源信息
	 */
	@Override
	public List<CustomerSource> findAllSource() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerSource> sourceList = new ArrayList<CustomerSource>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from customersource");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int souid = rs.getInt("souid");
				String souName = rs.getString("souName");
				String souDesc = rs.getString("souDesc");
				//2.将当前行各个字段的值封装到Employee对象中
				CustomerSource source = new CustomerSource(souid, souName, souDesc);
				//3.将user放入userList
				sourceList.add(source);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return sourceList;
	}
	/**
	 * 更新客户来源信息预查询
	 */
	@Override
	public CustomerSource findByIdSource(int souid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerSource source = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from customersource where souid = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）	
			pstmt.setInt(1, souid);
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			if(rs.next()){
				//1.取出当前行各个字段的值
				String souName = rs.getString("souName");
				String souDesc = rs.getString("souDesc");
				//2.将当前行各个字段的值封装到Employee对象中
				source = new CustomerSource(souid, souName, souDesc);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return source;
	}
	/**
	 * 根据条件查询客户来源信息
	 */
	@Override
	public List<CustomerSource> findSource(String souName2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerSource> sourceList = new ArrayList<CustomerSource>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from customersource where souName = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）	
			pstmt.setString(1, souName2);
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int souid = rs.getInt("souid");
				String souName = rs.getString("souName");
				String souDesc = rs.getString("souDesc");
				//2.将当前行各个字段的值封装到Employee对象中
				CustomerSource source = new CustomerSource(souid, souName, souDesc);
				//3.将user放入userList
				sourceList.add(source);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return sourceList;
	}

}

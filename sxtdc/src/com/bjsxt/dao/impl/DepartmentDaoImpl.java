package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.DepartmentDao;

import com.bjsxt.entity.Department;
import com.bjsxt.util.DBUtil;

/**
 * 部门信息
 * @author 无情
 *
 */
public class DepartmentDaoImpl implements DepartmentDao{

	/**
	 * 更新部门信息
	 */
	@Override
	public int updateDept(Department dept) {
		String sql = "update Department set deptName=?,deptDesc=?,Location=? where deptno= ?";
		Object [] params = {dept.getDeptName(),dept.getDeptDesc(),dept.getLocation(),dept.getDeptno()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 添加部门信息
	 */
	@Override
	public int saveDept(Department dept) {
		String sql = "insert into Department values(?,?,?,?)";
		Object [] params = {dept.getDeptno(),dept.getDeptName(),dept.getDeptDesc(),dept.getLocation()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 删除指定编号的部门信息
	 */
	@Override
	public int deleteDept(int deptno) {
		String sql = "delete from Department where deptno = ?";
		Object [] params = {deptno};
		
		return DBUtil.executeUpdate(sql, params);
	}
	
	/**
	 * 查询部门信息
	 */
	@Override
	public List<Department> findAllDept() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Department> deptList = new ArrayList<Department>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from Department");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int deptno = rs.getInt("deptno");
				String deptName = rs.getString("deptName");
				String deptDesc = rs.getString("deptDesc");
				String location = rs.getString("Location");
				//2.将当前行各个字段的值封装到Employee对象中
				Department dept = new Department(deptno, deptName, deptDesc, location);
				//3.将user放入userList
				deptList.add(dept);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return deptList;
	}
	/**
	 * 更新部门预查询
	 */
	@Override
	public Department findByIdDept(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Department dept = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from Department  where deptno = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）		
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			if(rs.next()){
				//1.取出当前行各个字段的值
				String deptName = rs.getString("deptName");
				String deptDesc = rs.getString("deptDesc");
				String location = rs.getString("Location");
				//2.将当前行各个字段的值封装到Employee对象中
				dept = new Department(deptno, deptName, deptDesc, location);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return dept;
	}
	
}

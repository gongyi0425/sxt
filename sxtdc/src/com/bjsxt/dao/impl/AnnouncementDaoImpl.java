package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.AnnouncementDao;
import com.bjsxt.entity.Announcement;
import com.bjsxt.entity.Employee;
import com.bjsxt.util.DBUtil;

public class AnnouncementDaoImpl implements AnnouncementDao {
	/**
	 * 添加公告
	 * 
	 * @author zhujiaming
	 * @return
	 */
	@Override
	public int addAnn(Announcement ann) {
		String sql = "insert into announcement values(seq_audit.nextval,?,?,?,?,?)";
		Object [] params = {ann.getEmpid(),ann.getAnntheme(),ann.getAnncontent(),
				new java.sql.Date(ann.getAnntime().getTime()),
				new java.sql.Date(ann.getAnnendtime().getTime())};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 更新公告
	 */
	@Override
	public int updateAnn(Announcement ann) {
		String sql = "update Announcement set anntheme=?,anncontent=?,anntime=?,annendtime=? where annid= ?";
		Object [] params = {
				ann.getAnntheme(),
				ann.getAnncontent(),
				new java.sql.Date(ann.getAnntime().getTime()),
				new java.sql.Date(ann.getAnnendtime().getTime()),
				ann.getAnnid()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 删除公告
	 */
	@Override
	public int deleteAnn(int annid) {
		String sql = "delete from Announcement where annid = ?";
		Object [] params = {annid};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 查询所有公告
	 */
	@Override
	public List<Announcement> findAllAnn(String query, Date city) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Announcement> annList = new ArrayList<Announcement>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder("select a.*,emp.Empname "
					+ "from announcement a "
					+ "join employee emp "
					+ "on a.empid = emp.empid "
					+ "where 1 = 1 ");
			if(query != null && !"".equals(query)){
				sql.append(" and a.anntheme like '%"+query+"%'");
			}
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(city != null){
				String anntime = sdf.format(city);
				sql.append("and to_char(a.anntime,'YYYY-MM-DD') >= '"+anntime+"'");
			}
			pstmt = conn.prepareStatement(sql.toString());
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int annid = rs.getInt("annid");  //公告编号
				String empid = rs.getString("empid"); //员工编号
				String empName = rs.getString("empName"); //员工姓名
				
				String anntheme = rs.getString("anntheme");//公告主题
				String anncontent = rs.getString("anncontent");//公告内容
				Date anntime = rs.getDate("anntime");  //公告时间
				Date annendtime = rs.getDate("annendtime"); //公告截止时间
				//2.将当前行各个字段的值封装到Employee对象中
				Announcement ann = new Announcement();
				ann.setAnnid(annid);
				ann.setAnntheme(anntheme);
				ann.setAnncontent(anncontent);
				ann.setAnntime(anntime);
				ann.setAnnendtime(annendtime);
				
				Employee emp = new Employee();
				emp.setEmpid(empid);
				emp.setEmpName(empName);
				ann.setEmp(emp);
				
				//3.将user放入userList
				annList.add(ann);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return annList;
	}
	/**
	 * 更新公告预查询
	 */
	@Override
	public Announcement findByIdAnn(int annid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Announcement ann = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select a.*,emp.Empname from announcement a join employee emp on a.empid = emp.empid");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				String empid = rs.getString("empid");
				String empName = rs.getString("empName");
				
				String anntheme = rs.getString("anntheme");
				String anncontent = rs.getString("anncontent");
				Date anntime = rs.getDate("anntime");
				Date annendtime = rs.getDate("annendtime");
				//2.将当前行各个字段的值封装到Employee对象中
				ann = new Announcement();
				ann.setAnnid(annid);
				ann.setAnntheme(anntheme);
				ann.setAnncontent(anncontent);
				ann.setAnntime(anntime);
				ann.setAnnendtime(annendtime);
				
				Employee emp = new Employee();
				emp.setEmpid(empid);
				emp.setEmpName(empName);
				ann.setEmp(emp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return ann;
	}
	
	

}

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

import com.bjsxt.dao.BargainDao;
import com.bjsxt.entity.Bargain;
import com.bjsxt.entity.Customer;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.House;
import com.bjsxt.entity.HouseType;
import com.bjsxt.util.DBUtil;

/**
 * 交易  Dao层 实现类
 * @author zhujiaming
 *
 */
public class BargainDaoImpl implements BargainDao{
	/**
	 * 添加交易
	 */
	@Override
	public int addBargain(Bargain bargain) {
		String sql = "insert into bargain values(seq_bar.nextval,?,?,?,?,?,?)";
		//先判断成交时间是否为空，为空添加当前时间
		java.sql.Date fixturedate02 = null;
		Date fixturedate = bargain.getFixturedate();
		if(fixturedate != null){
			fixturedate02 = new java.sql.Date(fixturedate.getTime());
		}else{
			Date date = new Date();
			fixturedate02 = new java.sql.Date(date.getTime());
		}
		Object [] params = {
				bargain.getCusid(),
				bargain.getEmpid(),
				bargain.getHouseid(),
				bargain.getBarprice(),
				fixturedate02,
				bargain.getBarDesc()};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 删除指定编号的交易
	 */
	@Override
	public int deleteBargain(int barid) {
		String sql = "delete from bargain where barid = ?";
		Object [] params = {barid};
		
		return DBUtil.executeUpdate(sql, params);
	}
	/**
	 * 查询所有交易
	 */
	@Override
	public List<Bargain> findByIdBargain(String query, Date squery, int queryType) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Bargain> bargainList = new ArrayList<Bargain>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder("select b.*,c.cusname ,e.empname,h.typeid,h.area,ht.typename"
					+ " from bargain b"
					+ " left join customer c"
					+ " on b.cusid = c.cusid"
					+ " left join employee e"
					+ " on b.empid = e.empid"
					+ " left join house h"
					+ " on b.houseid = h.houseid"
					+ " left join housetype ht"
					+ " on h.typeid = ht.typeid"
					+ " where 1 = 1");
			if(query != null && !"".equals(query) && queryType == 1){
				sql.append(" and b.barid like '%"+query+"%'");
			}
			if(query != null && !"".equals(query) && queryType == 2){
				sql.append(" and c.cusname like '%"+query+"%'");
			}
			if(query != null && !"".equals(query) && queryType == 3){
				sql.append(" and e.empname like '%"+query+"%'");
			}
			if(query != null && !"".equals(query) && queryType == 4){
				sql.append(" and ht.typename like '%"+query+"%'");
			}
			if(query != null && !"".equals(query) && queryType == 5){
				sql.append(" and h.area like '%"+query+"%'");
			}
			if(query != null && !"".equals(query) && queryType == 6){
				sql.append(" and b.barprice like '%"+query+"%'");
			}
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(squery != null){
				String bargaintime = sdf.format(squery);
				sql.append("and to_char(b.fixturedate,'YYYY-MM-DD') >= '"+bargaintime+"'");
			}
			pstmt = conn.prepareStatement(sql.toString());
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();	
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int barid = rs.getInt("barid");  //交易编号
				
				double barprice = rs.getDouble("barprice"); //成交价
				Date fixturedate = rs.getDate("fixturedate"); //交易时间
				String barDesc = rs.getString("barDesc"); //备注信息
				
				Customer cus = new Customer();
				int cusid = rs.getInt("cusid");  //客户编号
				String cusname = rs.getString("cusName"); //客户名字
				cus.setCusid(cusid);
				cus.setCusName(cusname);
				
				Employee emp = new Employee();
				String empid = rs.getString("empid");//员工编号
				String empname = rs.getString("empName"); //员工姓名
				emp.setEmpid(empid);
				emp.setEmpName(empname);
				
				House hou = new House();
				int houseid = rs.getInt("houseid"); //房屋编号
				double area = rs.getDouble("area"); //房屋面积
				
				String typeName = rs.getString("typeName"); //房屋类型名称
				
				HouseType type = new HouseType(typeName);
			
				
				hou.setArea(area);
				hou.setHouseid(houseid);
				hou.setType(type);
				//2.将当前行各个字段的值封装到Employee对象中
				Bargain bargain = new Bargain(barid, barprice, fixturedate, barDesc, cus, emp, hou);
				
				//3.将user放入userList
				bargainList.add(bargain);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return bargainList;
	}
	/**
	 * 查看交易详细信息
	 */
	@Override
	public Bargain findBarInfo(int barid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Bargain bargain = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder("select b.*,c.cusname ,e.empname,h.typeid,h.area,ht.typename"
					+ " from bargain b"
					+ " left join customer c"
					+ " on b.cusid = c.cusid"
					+ " left join employee e"
					+ " on b.empid = e.empid"
					+ " left join house h"
					+ " on b.houseid = h.houseid"
					+ " left join housetype ht"
					+ " on h.typeid = ht.typeid"
					+ " where 1 = 1");
			pstmt = conn.prepareStatement(sql.toString());
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();	
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				double barprice = rs.getDouble("barprice"); //成交价
				Date fixturedate = rs.getDate("fixturedate"); //交易时间
				String barDesc = rs.getString("barDesc"); //备注信息
				
				Customer cus = new Customer();
				int cusid = rs.getInt("cusid");  //客户编号
				String cusname = rs.getString("cusName"); //客户名字
				cus.setCusid(cusid);
				cus.setCusName(cusname);
				
				Employee emp = new Employee();
				String empid = rs.getString("empid");//员工编号
				String empname = rs.getString("empName"); //员工姓名
				emp.setEmpid(empid);
				emp.setEmpName(empname);
				
				House hou = new House();
				int houseid = rs.getInt("houseid"); //房屋编号
				double area = rs.getDouble("area"); //房屋面积
				
				String typeName = rs.getString("typeName"); //房屋类型名称
				
				HouseType type = new HouseType(typeName);
			
				
				hou.setArea(area);
				hou.setHouseid(houseid);
				hou.setType(type);
				//2.将当前行各个字段的值封装到Employee对象中
				bargain = new Bargain(barid, barprice, fixturedate, barDesc, cus, emp, hou);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return bargain;
	}
	
	


	/**
	 * 查询我的交易单
	 */
	public List<Bargain> findBarByEmpid(int barid2, String cusName2, double area2,
			double barPrice2 ,String empid2) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Bargain> bargainList = new ArrayList<Bargain>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder(""
								+" select b.*,c.cusname ,e.empname,h.area,ht.typename"
								+" from bargain b"
								+" left join customer c"
								+" on b.cusid = c.cusid"
								+" left join employee e"
								+" on b.empid = e.empid"
								+" left join house h"
								+" on b.houseid = h.houseid"
								+" left join housetype ht"
								+" on h.typeid = ht.typeid"
								+" where 1=1"
								);
			//判断是否增加查询条件
			if(empid2!=null && !("".equals(empid2))){
				sql.append(" and b.empid like '%"+empid2+"%'");
			}
			if(barid2>0 ){
				sql.append(" and b.barid = "+barid2);
			}
			if(area2>0 ){
				sql.append(" and h.area > "+area2);
			}
			if(barPrice2>0 ){
				sql.append(" and h.totalPrice > "+barPrice2);
			}
			if(cusName2!=null && !("".equals(cusName2))){
				sql.append(" and c.cusname like '%"+cusName2+"%'");
			}
			pstmt = conn.prepareStatement(sql.toString());
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();	
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int barid = rs.getInt("barid");  //交易单编号
				double barprice = rs.getDouble("barprice"); //成交价
				Date fixturedate = rs.getDate("fixturedate"); //交易时间
				String barDesc = rs.getString("barDesc"); //备注信息
				
				Customer cus = new Customer();
				int cusid = rs.getInt("cusid");  //客户编号
				String cusname = rs.getString("cusName"); //客户名字
				cus.setCusid(cusid);
				cus.setCusName(cusname);
				
				Employee emp = new Employee();
				String empid = rs.getString("empid");//员工编号
				String empname = rs.getString("empName"); //员工姓名
				emp.setEmpid(empid);
				emp.setEmpName(empname);
				
				House hou = new House();
				int houseid = rs.getInt("houseid"); //房屋编号
				double area = rs.getDouble("area"); //房屋面积
				
				String typeName = rs.getString("typeName"); //房屋类型名称
				
				HouseType type = new HouseType(typeName);
			
				
				hou.setArea(area);
				hou.setHouseid(houseid);
				hou.setType(type);
				//2.将当前行各个字段的值封装到Employee对象中
				Bargain bargain = new Bargain(barid, barprice, fixturedate, barDesc, cus, emp, hou);
				
				//3.将user放入userList
				bargainList.add(bargain);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return bargainList;
	}

}

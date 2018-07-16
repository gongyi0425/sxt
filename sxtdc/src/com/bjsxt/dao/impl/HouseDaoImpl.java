package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.HouseDao;
import com.bjsxt.entity.House;
import com.bjsxt.entity.HouseType;
import com.bjsxt.util.DBUtil;
import com.bjsxt.util.DBUtilService;
/**
 * 房屋信息
 * @author 潘培轩
 *
 */
public class HouseDaoImpl implements HouseDao{

	/*
	 * 添加房屋信息
	 */
	@Override
	public int save(House house) {
		String sql = "insert into house values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {house.getHouseid(),house.getTypeid(),house.getLocation(),
				house.getPrice(),house.getArea(),house.getTotalPrice(),house.getAmbient(),
				house.getHousestate(),house.getHouseDesc()};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询所有房屋信息
	 */
	@Override
	public List<House> findAllHouse() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<House> houselist = new ArrayList<House>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select h.houseid,h.location,h.price,h.area,"
					+ " h.totalprice,h.ambient,h.housestate,h.housedesc,h.typeid,ht.typename" 
					+ " from house h"
					+ " join housetype ht"
					+ " on h.typeid = ht.typeid");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int houseid = rs.getInt("houseid");
				String location = rs.getString("location");
				double price = rs.getDouble("price");
				double area = rs.getDouble("area");
				double totalPrice = rs.getDouble("totalprice");
				String ambient = rs.getString("ambient");
				String housestate = rs.getString("housestate");
				String houseDesc = rs.getString("housedesc");

				//2.将当前行各个字段的值封装到Employee对象中
				House house = new House();
				house.setHouseid(houseid);
				house.setLocation(location);
				house.setPrice(price);
				house.setArea(area);
				house.setTotalPrice(totalPrice);
				house.setAmbient(ambient);
				house.setHousestate(housestate);
				house.setHouseDesc(houseDesc);
				
				int typeid = rs.getInt("typeid");
				String typeName = rs.getString("typeName");
				HouseType type = new HouseType(typeid,typeName,null);
				house.setType(type);
				//3.将user放入userList
				houselist.add(house);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return houselist;
	}

	/*
	 * 按条件查询房屋信息（查询所有是按条件查询的一种特殊形式）
	 */
	@Override
	public List<House> findHouse(String location2, int typeid2, String housestate2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<House> houselist = new ArrayList<House>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder("select h.houseid,h.location,h.price,"
					+ " h.area,h.totalprice,h.ambient,h.housestate,h.housedesc,h.typeid,ht.typename "
					+ " from house h"
					+ " join housetype ht"
					+ " on h.typeid = ht.typeid"
					+ " where 1=1");
			if(location2 != null && !"".equals(location2)){
				sql.append(" and h.location like '%"+location2+"%'");
			}
			if(typeid2 != 0){
				sql.append(" and h.typeid="+typeid2);
			}
			if(housestate2 != null && !"".equals(housestate2)){
				sql.append(" and h.housestate like '%"+housestate2+"%'");
			}
			pstmt = conn.prepareStatement(sql.toString());
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int houseid = rs.getInt("houseid");
				String location = rs.getString("location");
				double price = rs.getDouble("price");
				double area = rs.getDouble("area");
				double totalPrice = rs.getDouble("totalprice");
				String ambient = rs.getString("ambient");
				String housestate = rs.getString("housestate");
				String houseDesc = rs.getString("housedesc");

				//2.将当前行各个字段的值封装到Employee对象中
				House house = new House();
				house.setHouseid(houseid);
				house.setLocation(location);
				house.setPrice(price);
				house.setArea(area);
				house.setTotalPrice(totalPrice);
				house.setAmbient(ambient);
				house.setHousestate(housestate);
				house.setHouseDesc(houseDesc);
				
				int typeid = rs.getInt("typeid");
				String typeName = rs.getString("typeName");
				HouseType type = new HouseType(typeid,typeName,null);
				house.setType(type);
				//3.将user放入userList
				houselist.add(house);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return houselist;
	}
	/**
	 * 查询房屋功能
	 */
	@Override
	public List<House> findHouseName(int houName, String typeName2, double price2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<House> houseList = new ArrayList<House>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			StringBuilder sql = new StringBuilder("select h.houseid,h.location,h.price,h.area,"
					+ " h.totalprice,h.ambient,h.housestate,h.housedesc,h.typeid,ht.typename" 
					+ " from house h"
					+ " join housetype ht"
					+ " on h.typeid = ht.typeid"
					+ " where 1 = 1 ");
			
			if(houName > 0){
				sql.append(" and houseid ="+houName);
			}
			
			if(typeName2 != null && !"".equals(typeName2)){
				sql.append(" and ht.typename like '%"+typeName2+"%'");
			}
			
			if(price2 > 0){
				sql.append(" and h.price ="+price2);
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int houseid = rs.getInt("houseid");
				String location = rs.getString("location");
				double price = rs.getDouble("price");
				double area = rs.getDouble("area");
				//2.将当前行各个字段的值封装到Employee对象中
				House house = new House();
				
				house.setHouseid(houseid);
				house.setLocation(location);
				house.setPrice(price);
				house.setArea(area);
				
				int typeid = rs.getInt("typeid");
				String typeName = rs.getString("typeName");
				HouseType type = new HouseType(typeid,typeName,null);
				house.setType(type);
				//3.将user放入userList
				houseList.add(house);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return houseList;
	}

	/*
	 * 删除房屋
	 */
	@Override
	public int deleteHouse(int houseid) {
		String sql = "delete from house where houseid = ?";
		Object[] params = {houseid};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询指定编号的房屋信息
	 */
	@Override
	public House findHouseById(int houseid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		House house = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from house where houseid = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）
			pstmt.setInt(1, houseid);
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				String location = rs.getString("location");
				double price = rs.getDouble("price");
				double area = rs.getDouble("area");
				double totalPrice = rs.getDouble("totalprice");
				String ambient = rs.getString("ambient");
				String housestate = rs.getString("housestate");
				String houseDesc = rs.getString("housedesc");

				//2.将当前行各个字段的值封装到Employee对象中
				int typeid = rs.getInt("typeid");
				HouseType type = new HouseType();
				type.setTypeid(typeid);
				
//				house = new House(houseid,location, price, area, totalPrice, ambient, housestate, houseDesc,type);
				house = new House(houseid, typeid, location, price, area, totalPrice, ambient, housestate, houseDesc, type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return house;
	}

	/*
	 * 更新房屋信息
	 */

	public int updateHouse(House house) {
		String sql = "update house set typeid = ?,location = ?,price = ?,area = ?,totalprice=?,"
				+ " ambient=?,housestate=?,housedesc=? where houseid = ?";
		Object[] params = {house.getTypeid(),house.getLocation(),house.getPrice(),
				house.getArea(),house.getTotalPrice(),house.getAmbient(),
				house.getHousestate(),house.getHouseDesc(),house.getHouseid()};
		return DBUtil.executeUpdate(sql, params);
	}

	/**
	 * 得到房屋编号的下一个值   利用伪表实现主键自增
	 */
	public int nextVal() {				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 创建一个list集合
		int nextval = 0;
		try {
			// 2.建立和数据库的连接（url，user、password）
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select seq_house.nextval from dual");
			rs = pstmt.executeQuery();
			// 得到伪表自增的下一个值
			rs.next();
			nextval = rs.getInt("nextval");				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			DBUtil.closeAll(rs, pstmt, null);
		}
		return nextval;
	}

	/**
	 * 保存房屋信息到数据库
	 */
	public void saveHou(House house) {
		String sql = "insert into house values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {
							house.getHouseid(),
							house.getTypeid(),
							house.getLocation(),
							house.getPrice(),
							house.getArea(),
							house.getTotalPrice(),
							house.getAmbient(),
							house.getHousestate(),
							house.getHouseDesc()};
		DBUtilService.executeUpdate(sql, params);
		
	}

	/**
	 * 修改房屋状态
	 */
	@Override
	public int updateHouseState(int hoousid) {
		String sql = "update house set housestate = ? where houseid=?";
		String State = "已售";
		Object[] params = {
				State,
				hoousid
				
		};
							
		return DBUtilService.executeUpdate(sql, params);
	}

}

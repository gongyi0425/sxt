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

import com.bjsxt.dao.PositionDao;
import com.bjsxt.entity.Position;
import com.bjsxt.util.DBUtil;

public class PositionDaoImpl implements PositionDao {

	/*
	 * 添加岗位
	 */
	@Override
	public int savePos(Position position) {
		String sql = "insert into position values(?,?,?)";
		Object[] params = {position.getPosid(),position.getPosName(),position.getPosDesc()};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询所有岗位信息
	 */
	@Override
	public List<Position> findAllPos() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Position> positionList = new ArrayList<Position>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from position");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				int posid = rs.getInt("posid");
				String posName = rs.getString("posName");
				String posDesc = rs.getString("posdesc");
				//2.将当前行各个字段的值封装到Employee对象中
				Position position = new Position(posid, posName, posDesc);
				//3.将user放入userList
				positionList.add(position);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return positionList;
	}

	/*
	 * 删除岗位
	 */
	@Override
	public int deletePos(int posid) {
		String sql = "delete from position where posid = ?";
		Object[] params = {posid};
		return DBUtil.executeUpdate(sql, params);
	}

	/*
	 * 查询指定编号的岗位
	 */
	@Override
	public Position findPosById(int posid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Position position = null;
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from position where posid = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）	
			pstmt.setInt(1, posid);
			rs = pstmt.executeQuery();
			//5.处理结果（封装到List中）
			if(rs.next()){
				//1.取出当前行各个字段的值
				String posName = rs.getString("posName");
				String posDesc = rs.getString("posdesc");
				//2.将当前行各个字段的值封装到Employee对象中
				position = new Position(posid, posName, posDesc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		//7.返回数据		
		return position;
	}

	/*
	 * 更新岗位
	 */
	@Override
	public int updatePos(Position position) {
		String sql = "update position set posName = ?,posDesc = ? where posid = ?";
		Object[] params = {position.getPosName(),position.getPosDesc(),position.getPosid()};
		return DBUtil.executeUpdate(sql, params);
	}

}

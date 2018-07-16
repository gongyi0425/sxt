package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.HouseImgDao;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.HouseImg;
import com.bjsxt.util.DBUtil;
import com.bjsxt.util.DBUtilService;

/**
 * 房屋图片DAO实现类
 * @author ZhaoWeiGuang
 *
 */
public class HouseImgDaoImpl implements HouseImgDao {

	/**
	 * 保存图片到数据库
	 * 
	 */
	public void saveImg(HouseImg img) {
		String sql = "insert into houseimg values(seq_houseimg.nextval,?,?,?,?)";
		Object[] params = {
							img.getHouseid(),
							img.getImgType(),
							img.getImgUploadName(),
							img.getImgName()
				
							};
		DBUtilService.executeUpdate(sql, params);
		
	}

	/**
	 * 根据房屋编号查询图片
	 */
	public List<HouseImg> findImgByHouseId(int houseid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 创建一个list集合
		List<HouseImg> imgList = new ArrayList<HouseImg>();
		try {
			// 2.建立和数据库的连接（url，user、password）
			conn = DBUtil.getConnection();
			// 创建可变字符串 方便sql语句的拼接 默认是查询全部
			String sql = "select * from houseimg where houseid="+houseid;
			
			// 3.创建SQL命令发送器
			pstmt = conn.prepareStatement(sql);
			// 4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果
			rs = pstmt.executeQuery();
			// 5.处理结果
			while(rs.next()) {
				int imgid = rs.getInt("imgid");
				String imgType = rs.getString("imgType");
				String imgUploadName = rs.getString("imgUploadName");
				String imgName = rs.getString("imgName");
				
				HouseImg img = new HouseImg(imgid, houseid, imgType, imgUploadName, imgName);
		
				imgList.add(img);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		// 7.返回数据
		return imgList;
	}

	/**
	 * 下载图片
	 */
	public HouseImg findByImgId(int imgid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 创建一个list集合
		HouseImg img = null;
		try {
			// 2.建立和数据库的连接（url，user、password）
			conn = DBUtil.getConnection();
			// 创建可变字符串 方便sql语句的拼接 默认是查询全部
			String sql = "select * from houseimg where houseid="+imgid;
			
			// 3.创建SQL命令发送器
			pstmt = conn.prepareStatement(sql);
			// 4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果
			rs = pstmt.executeQuery();
			// 5.处理结果
			if(rs.next()) {
				int houseid = rs.getInt("houseid");
				String imgType = rs.getString("imgType");
				String imgUploadName = rs.getString("imgUploadName");
				String imgName = rs.getString("imgName");
				
				img = new HouseImg(imgid, houseid, imgType, imgUploadName, imgName);
		
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		// 7.返回数据
		return img;
	}

}

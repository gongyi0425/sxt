package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.CustomerReviewDao;
import com.bjsxt.entity.CustomerReview;
import com.bjsxt.util.DBUtil;

public class CustomerReviewDaoImpl implements CustomerReviewDao{
	
	/**
	 * @author huming
	 * 添加客户回访
	 * 
	 */
	@Override
	public int addReview(CustomerReview review) {
		String sql = "insert into customerreview value(?,?,?)";		
		Object[] params = {review.getReviewId(),review.getReviewName(),review.getReviewDesc()};
		return DBUtil.executeUpdate(sql, params);
		
	}
	/**
	 * 查询所有客户回访信息
	 */
	@Override
	public List<CustomerReview> findAllReview() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerReview> reviewList = new ArrayList<CustomerReview>();
		try {
			//建立与数据库的连接
			conn =DBUtil.getConnection();
			//创建SQL语句命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from customerreview");
			//讲SQL语句发送给数据库，并返回查询结果
			rs = pstmt.executeQuery();
			//处理结果
			while(rs.next()){
				//1.取出当前行各个字段的值
				int reviewId = rs.getInt("reviewid");
				String reviewName = rs.getString("reviewname");
				String reviewDesc = rs.getString("reviewdesc");
				//2.将当前行各个字段的值封装到Employee对象中
				CustomerReview review = new CustomerReview(reviewId, reviewName, reviewDesc);
				//3.将user放入userList
				reviewList.add(review);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return reviewList;
	}
	
	/**
	 * 根据客户回访ID进行查询
	 */
	@Override
	public CustomerReview findByIdReview(int reviewId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerReview source = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from customerreview where reviewId = ?");
			pstmt.setInt(1, reviewId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String reviewName = rs.getString("reviewName");
				String reviewDesc = rs.getString("reviewDesc");
				source = new CustomerReview(reviewId,reviewName,reviewDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return source;
	}
	
	/**
	 * 更新客户回访信息
	 */
	@Override
	public int updateReview(CustomerReview review) {
		String sql = "update customerreview set reviewID=?,reviewName=?,reviewDesc=?";
		Object[] params = {review.getReviewId(),review.getReviewName(),review.getReviewDesc()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	/**
	 * 删除客户回访信息
	 */
	@Override
	public int deleteReview(int reviewId) {
		String sql = "delete from customerreview where reviewID=?";
		Object[] params = {reviewId};
		return DBUtil.executeUpdate(sql, params);
	}
	
	/**
	 * 根据条件查询客户回访信息
	 */
	@Override
	public List<CustomerReview> findReview(String reviewName2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerReview> reviewList = new ArrayList<CustomerReview>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from customerreview where reviewName =?");
			pstmt.setString(1,reviewName2);
			while(rs.next()){
				int reviewId= rs.getInt("reviewId");
				String reviewName = rs.getString("reviewName");
				String reviewDesc = rs.getString("reviewDesc");
				CustomerReview review = new CustomerReview(reviewId,reviewName,reviewDesc);
				reviewList.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return reviewList;
	}
	
}

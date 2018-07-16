package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.AnalyzeReviewDao;
import com.bjsxt.entity.*;
import com.bjsxt.util.DBUtil;
import com.google.gson.Gson;
public class AnalyzeReviewDaoImpl implements AnalyzeReviewDao{

	@Override
	public String analyzeReview() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AnalyzeReview analyzeReview = null;
		List<AnalyzeReview> reviewList = new  ArrayList<AnalyzeReview>();
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("select REVIEWNAME,count(REVIEWNAME) REVIEWNUM from CUSTOMER GROUP BY REVIEWNAME ORDER BY REVIEWNUM DESC");
			rs = pstmt.executeQuery();
			while(rs.next()){
				/*analyzeReview.setReviewName(rs.getString("REVIEWNAME"));
				analyzeReview.setReviewNum(rs.getInt("REVIEWNUM"));*/
				String reviewName = rs.getString("REVIEWNAME");
				int reviewNum = rs.getInt("REVIEWNUM");
				analyzeReview = new AnalyzeReview(reviewName,reviewNum);
				reviewList.add(analyzeReview);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		Gson gson = new Gson();
		String str = gson.toJson(reviewList);
		return str;
	}
	
}

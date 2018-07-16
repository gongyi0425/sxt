package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.AnalyzeAttentionDao;
import com.bjsxt.entity.AnalyzeAttention;
import com.bjsxt.entity.AnalyzeReview;
import com.bjsxt.util.DBUtil;
import com.google.gson.Gson;

public class AnalyzeAttentionDaoImpl implements AnalyzeAttentionDao{

	@Override
	public String analyzeAttention() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AnalyzeAttention analyzeAttention = null;
		List<AnalyzeAttention> attentionList = new  ArrayList<AnalyzeAttention>();
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("select ATTENTIONNAME,count(ATTENTIONNAME) ATTENTIONNUM from CUSTOMER GROUP BY ATTENTIONNAME ORDER BY count(ATTENTIONNAME) desc");
			rs = pstmt.executeQuery();
			while(rs.next()){
				String attentionName = rs.getString("ATTENTIONNAME");
				int attentionNum = rs.getInt("ATTENTIONNUM");
				analyzeAttention = new AnalyzeAttention(attentionName,attentionNum);
				attentionList.add(analyzeAttention);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		Gson gson = new Gson();
		String str = gson.toJson(attentionList);
		return str;
	}

}

package com.bjsxt.service.impl;

import com.bjsxt.dao.AnalyzeReviewDao;
import com.bjsxt.dao.impl.AnalyzeReviewDaoImpl;
import com.bjsxt.service.AnalyzeReviewService;

public class AnalyzeReviewServiceImpl implements AnalyzeReviewService{
	AnalyzeReviewDao analyzeReviewDao = new AnalyzeReviewDaoImpl();
	
	@Override
	public String analyzeReview() {
		return this.analyzeReviewDao.analyzeReview();
	}
}

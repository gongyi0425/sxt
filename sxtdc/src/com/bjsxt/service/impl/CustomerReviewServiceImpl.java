package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.CustomerReviewDao;
import com.bjsxt.dao.impl.CustomerReviewDaoImpl;
import com.bjsxt.entity.CustomerReview;
import com.bjsxt.service.CustomerReviewService;

public class CustomerReviewServiceImpl implements CustomerReviewService{
	
	CustomerReviewDao reviewDao = new CustomerReviewDaoImpl();
	
	/**
	 * 创建客户回访信息
	 */
	@Override
	public int addReview(CustomerReview review) {
		return this.reviewDao.addReview(review);
	}

	@Override
	public List<CustomerReview> findAllReview() {
		return this.reviewDao.findAllReview();
	}

	@Override
	public CustomerReview findByIdReview(int reviewId) {
		return this.reviewDao.findByIdReview(reviewId);
	}

	@Override
	public int updateReview(CustomerReview review) {
		return this.reviewDao.updateReview(review);
	}

	@Override
	public int deleteReview(int reviewId) {
		return this.reviewDao.deleteReview(reviewId);
	}

	@Override
	public List<CustomerReview> findReview(String reviewName) {
		return this.reviewDao.findReview(reviewName);
	}

}

package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.CustomerReview;

public interface CustomerReviewDao {
	/**
	 * 创建客户回访类型
	 */
	int addReview(CustomerReview review);
	
	/**
	 * 查询所有客户回访信息
	 */
	List<CustomerReview> findAllReview();
	
	/**
	 * 更新客户回访信息预查询
	 */
	CustomerReview findByIdReview(int reviewId);
	
	/**
	 * 更新客户回访信息
	 */
	int updateReview(CustomerReview review);
	
	/**
	 * 删除制定编号的客户回访信息
	 */
	int deleteReview(int reviewId);
	
	/**
	 * 根据条件查询客户回访信息
	 */
	List<CustomerReview> findReview(String reviewName);
	
}

package com.bjsxt.entity;

public class CustomerReview {
	private int reviewId;			//回访类型Id
	private String ReviewName;		//回访类型名称
	private String ReviewDesc;		//回访类型描述
	
	
	//构造方法
	public CustomerReview() {
		super();
	}
	public CustomerReview(int reviewId, String reviewName, String reviewDesc) {
		super();
		this.reviewId = reviewId;
		ReviewName = reviewName;
		ReviewDesc = reviewDesc;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewName() {
		return ReviewName;
	}
	public void setReviewName(String reviewName) {
		ReviewName = reviewName;
	}
	public String getReviewDesc() {
		return ReviewDesc;
	}
	public void setReviewDesc(String reviewDesc) {
		ReviewDesc = reviewDesc;
	}
	
}

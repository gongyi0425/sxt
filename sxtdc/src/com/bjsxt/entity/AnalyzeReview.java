package com.bjsxt.entity;

public class AnalyzeReview {
	private String ReviewName;
	private int ReviewNum;
	public String getReviewName() {
		return ReviewName;
	}
	public void setReviewName(String reviewName) {
		ReviewName = reviewName;
	}
	public int getReviewNum() {
		return ReviewNum;
	}
	public void setReviewNum(int reviewNum) {
		ReviewNum = reviewNum;
	}
	public AnalyzeReview(String reviewName, int reviewNum) {
		super();
		ReviewName = reviewName;
		ReviewNum = reviewNum;
	}
	public AnalyzeReview() {
		super();
	}
	
}

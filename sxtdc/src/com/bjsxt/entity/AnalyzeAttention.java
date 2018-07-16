package com.bjsxt.entity;

public class AnalyzeAttention {
	private String AttentionName;	//关注类型名称;
	private int AttentionNum;		//关注类型数量;
	public AnalyzeAttention(String attentionName, int attentionNum) {
		super();
		AttentionName = attentionName;
		AttentionNum = attentionNum;
	}
	public String getAttentionName() {
		return AttentionName;
	}
	public void setAttentionName(String attentionName) {
		AttentionName = attentionName;
	}
	public int getAttentionNum() {
		return AttentionNum;
	}
	public void setAttentionNum(int attentionNum) {
		AttentionNum = attentionNum;
	}
	
	
}

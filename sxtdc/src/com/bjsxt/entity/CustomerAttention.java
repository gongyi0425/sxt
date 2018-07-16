package com.bjsxt.entity;

public class CustomerAttention {
	private int AttentionId;		//关注类型的ID
	private String AttentionName;	//关注类型的名称
	private int HouseId;			//对应HouseType表的HouseId
	private String AttentionDesc;	//关注类型的备注信息
	public int getAttentionId() {
		return AttentionId;
	}
	public void setAttentionId(int attentionId) {
		AttentionId = attentionId;
	}
	public String getAttentionName() {
		return AttentionName;
	}
	public void setAttentionName(String attentionName) {
		AttentionName = attentionName;
	}
	public int getHouseId() {
		return HouseId;
	}
	public void setHouseId(int houseId) {
		HouseId = houseId;
	}
	public String getAttentionDesc() {
		return AttentionDesc;
	}
	public void setAttentionDesc(String attentionDesc) {
		AttentionDesc = attentionDesc;
	}
	public CustomerAttention(int attentionId, String attentionName, int houseId, String attentionDesc) {
		super();
		AttentionId = attentionId;
		AttentionName = attentionName;
		HouseId = houseId;
		AttentionDesc = attentionDesc;
	}
	
}

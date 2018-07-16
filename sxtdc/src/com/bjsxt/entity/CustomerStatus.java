package com.bjsxt.entity;
/**
 * 客户状态表
 * @author ZhaoWeiguang
 *
 */
public class CustomerStatus {

	private int staid;     //状态编号
	private String staName;//状态名称
	private String staDesc;//状态描述
	
	//构造方法
	public CustomerStatus() {
		super();
	}

	public CustomerStatus(int staid, String staName, String staDesc) {
		super();
		this.staid = staid;
		this.staName = staName;
		this.staDesc = staDesc;
	}

	public int getStaid() {
		return staid;
	}

	public void setStaid(int staid) {
		this.staid = staid;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public String getStaDesc() {
		return staDesc;
	}

	public void setStaDesc(String staDesc) {
		this.staDesc = staDesc;
	}

	@Override
	public String toString() {
		return "Status [staid=" + staid + ", staName=" + staName + ", staDesc="
				+ staDesc + "]";
	}
	
	
}

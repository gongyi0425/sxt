package com.bjsxt.entity;
/**
 * 客户来源信息
 * @author ZhaoWeiguang
 *
 */
public class CustomerSource {
	
	private int souid;      //来源编号
	private String souName; //来源名称
	private String souDesc;    //来源描述

	//构造方法
	public CustomerSource() {
		super();
	}

	public CustomerSource(int souid, String souName, String souDesc) {
		super();
		this.souid = souid;
		this.souName = souName;
		this.souDesc = souDesc;
	}

	public int getSouid() {
		return souid;
	}

	public void setSouid(int souid) {
		this.souid = souid;
	}

	public String getSouName() {
		return souName;
	}

	public void setSouName(String souName) {
		this.souName = souName;
	}

	public String getSouDesc() {
		return souDesc;
	}

	public void setSouDesc(String souDesc) {
		this.souDesc = souDesc;
	}

	@Override
	public String toString() {
		return "CustomerSource [souid=" + souid + ", souName=" + souName
				+ ", souDesc=" + souDesc + "]";
	}
	
	

}

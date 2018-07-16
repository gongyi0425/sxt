package com.bjsxt.entity;

public class Area {
	private int areaID;
	private String areaName;
	private int parentID;
	
	
	public Area() {
		super();
	}


	public Area(int areaID, String areaName, int parentID) {
		super();
		this.areaID = areaID;
		this.areaName = areaName;
		this.parentID = parentID;
	}


	public int getAreaID() {
		return areaID;
	}


	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public int getParentID() {
		return parentID;
	}


	public void setParentID(int parentID) {
		this.parentID = parentID;
	}


	@Override
	public String toString() {
		return "Area [areaID=" + areaID + ", areaName=" + areaName
				+ ", parentID=" + parentID + "]";
	}
	
	
	
	

}

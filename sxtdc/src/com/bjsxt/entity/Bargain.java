package com.bjsxt.entity;

import java.util.Date;

/**
 * 交易表
 * @author zhujiaming
 *
 */
public class Bargain {
	
	private int barid;     //单号   序列自增
	private int cusid;     //客户编号
	private String empid;     //员工编号
	private int houseid;   //房屋编号
	private double barprice;  //成交价
	private Date fixturedate; //成交日期  填写交易单的时间  自动获取
	private String fouder;    //创建人    当前登录用户的姓名   自动获取
	private String barDesc;   //备注信息
	
	private Customer cus;
	private Employee emp;
	private House hou;
	
	//空构造方法
	public Bargain() {
		super();
	}


	public Bargain(int cusid, String empid) {
		super();
		this.cusid = cusid;
		this.empid = empid;
	}


	public Bargain(int cusid, String empid, int houseid, double barprice,
			Date fixturedate, String fouder, String barDesc) {
		super();
		this.cusid = cusid;
		this.empid = empid;
		this.houseid = houseid;
		this.barprice = barprice;
		this.fixturedate = fixturedate;
		this.fouder = fouder;
		this.barDesc = barDesc;
	}
	

	public Bargain(int barid, double barprice, Date fixturedate,
			String barDesc, Customer cus, Employee emp, House hou) {
		super();
		this.barid = barid;
		this.barprice = barprice;
		this.fixturedate = fixturedate;
		this.barDesc = barDesc;
		this.cus = cus;
		this.emp = emp;
		this.hou = hou;
	}


	//全部属性构造方法
	public Bargain(int barid, int cusid, String empid, int houseid,
			double barprice, Date fixturedate, String fouder, String barDesc) {
		super();
		this.barid = barid;
		this.cusid = cusid;
		this.empid = empid;
		this.houseid = houseid;
		this.barprice = barprice;
		this.fixturedate = fixturedate;
		this.fouder = fouder;
		this.barDesc = barDesc;
	}


	public int getBarid() {
		return barid;
	}


	public void setBarid(int barid) {
		this.barid = barid;
	}


	public int getCusid() {
		return cusid;
	}


	public void setCusid(int cusid) {
		this.cusid = cusid;
	}


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public int getHouseid() {
		return houseid;
	}


	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}


	public double getBarprice() {
		return barprice;
	}


	public void setBarprice(double barprice) {
		this.barprice = barprice;
	}


	public Date getFixturedate() {
		return fixturedate;
	}


	public void setFixturedate(Date fixturedate) {
		this.fixturedate = fixturedate;
	}


	public String getFouder() {
		return fouder;
	}


	public void setFouder(String fouder) {
		this.fouder = fouder;
	}


	public String getBarDesc() {
		return barDesc;
	}


	public void setBarDesc(String barDesc) {
		this.barDesc = barDesc;
	}

	
	public Customer getCus() {
		return cus;
	}


	public void setCus(Customer cus) {
		this.cus = cus;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}


	public House getHou() {
		return hou;
	}


	public void setHou(House hou) {
		this.hou = hou;
	}


	@Override
	public String toString() {
		return "Bargain [barid=" + barid + ", cusid=" + cusid + ", empid="
				+ empid + ", houseid=" + houseid + ", barprice=" + barprice
				+ ", fixturedate=" + fixturedate + ", fouder=" + fouder
				+ ", barDesc=" + barDesc + "]";
	}


	
	
	
	
	

}

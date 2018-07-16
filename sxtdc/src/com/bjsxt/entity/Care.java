package com.bjsxt.entity;

import java.util.Date;

/**
 *  客户关怀表
 * @author ZhaoWeiguang
 *
 */
public class Care {
	
	private int careid;       //关怀编号
	private int cusid;        //客户编号
	private int empid;        //员工编号
	private String careTheme; //关怀主题
	private String careWay;   //关怀方式
	private Date careTime;    //关怀时间
	private Date careNextTime;//下次关怀时间
	private String careDesc;  //备注信息
	
	private Employee emp;     //存储关怀员工的所有信息
	private Customer cus;     //存储被关怀客户的所有信息
	
	
	//构造方法
	public Care() {
		super();
	}

	//全部属性构造方法
	public Care(int careid, int cusid, int empid, String careTheme,
			String careWay, Date careTime, Date careNextTime, String careDesc,
			Employee emp, Customer cus) {
		super();
		this.careid = careid;
		this.cusid = cusid;
		this.empid = empid;
		this.careTheme = careTheme;
		this.careWay = careWay;
		this.careTime = careTime;
		this.careNextTime = careNextTime;
		this.careDesc = careDesc;
		this.emp = emp;
		this.cus = cus;
	}

	public int getCareid() {
		return careid;
	}

	public void setCareid(int careid) {
		this.careid = careid;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getCareTheme() {
		return careTheme;
	}

	public void setCareTheme(String careTheme) {
		this.careTheme = careTheme;
	}

	public String getCareWay() {
		return careWay;
	}

	public void setCareWay(String careWay) {
		this.careWay = careWay;
	}

	public Date getCareTime() {
		return careTime;
	}

	public void setCareTime(Date careTime) {
		this.careTime = careTime;
	}

	public Date getCareNextTime() {
		return careNextTime;
	}

	public void setCareNextTime(Date careNextTime) {
		this.careNextTime = careNextTime;
	}

	public String getCareDesc() {
		return careDesc;
	}

	public void setCareDesc(String careDesc) {
		this.careDesc = careDesc;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	@Override
	public String toString() {
		return "Care [careid=" + careid + ", cusid=" + cusid + ", empid="
				+ empid + ", careTheme=" + careTheme + ", careWay=" + careWay
				+ ", careTime=" + careTime + ", careNextTime=" + careNextTime
				+ ", careDesc=" + careDesc + ", emp=" + emp + ", cus=" + cus
				+ "]";
	}


	
	
	
	
}

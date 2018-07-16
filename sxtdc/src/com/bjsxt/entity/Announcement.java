package com.bjsxt.entity;

import java.util.Date;

/**
 * 公告
 * @author 无情
 *
 */
public class Announcement {
	private int annid;//公告编号
	private String empid;//员工编号
	private String anntheme;//公告主题
	private String anncontent;//公告内容
	private Date anntime;//公告时间
	private Date annendtime;//公告截止时间
	
	private Employee emp;

	public Announcement() {
		super();
	}
	
	public Announcement(int annid, String anntheme, String anncontent,
			Date anntime, Date annendtime) {
		super();
		this.annid = annid;
		this.anntheme = anntheme;
		this.anncontent = anncontent;
		this.anntime = anntime;
		this.annendtime = annendtime;
	}

	public Announcement(String empid, String anntheme, String anncontent,
			Date anntime, Date annendtime) {
		super();
		this.empid = empid;
		this.anntheme = anntheme;
		this.anncontent = anncontent;
		this.anntime = anntime;
		this.annendtime = annendtime;
	}

	public Announcement(int annid, String empid, String anntheme,
			String anncontent, Date anntime, Date annendtime, Employee emp) {
		super();
		this.annid = annid;
		this.empid = empid;
		this.anntheme = anntheme;
		this.anncontent = anncontent;
		this.anntime = anntime;
		this.annendtime = annendtime;
		this.emp = emp;
	}

	public int getAnnid() {
		return annid;
	}

	public void setAnnid(int annid) {
		this.annid = annid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getAnntheme() {
		return anntheme;
	}

	public void setAnntheme(String anntheme) {
		this.anntheme = anntheme;
	}

	public String getAnncontent() {
		return anncontent;
	}

	public void setAnncontent(String anncontent) {
		this.anncontent = anncontent;
	}

	public Date getAnntime() {
		return anntime;
	}

	public void setAnntime(Date anntime) {
		this.anntime = anntime;
	}

	public Date getAnnendtime() {
		return annendtime;
	}

	public void setAnnendtime(Date annendtime) {
		this.annendtime = annendtime;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Announcement [annid=" + annid + ", empid=" + empid
				+ ", anntheme=" + anntheme + ", anncontent=" + anncontent
				+ ", anntime=" + anntime + ", annendtime=" + annendtime
				+ ", emp=" + emp + "]";
	}

	
	
}

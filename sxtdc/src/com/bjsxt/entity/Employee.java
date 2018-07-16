package com.bjsxt.entity;

import java.util.Date;

/**
 * 员工表
 * @author ZhaoWeiguang
 *
 */

public class Employee {

	private String empid;    //员工编号
	private String password; //密码
	private int deptno;      //部门编号
	private int posid;       //岗位编号
	private String mgrid;    //上级编号
	private String empName;  //员工姓名
	private int empAge;      //员工年龄
	private String empSex;   //性别
	private String empEducation;  //学历
	private String idcard;   //身份证号
	private String nation;   //民族
	private String marry;    //婚否
	private String phone;    //手机
	private String qq;       //qq
	private String address;  //家庭住址
	private String email;    //邮箱
	private int empType;     //员工类型      规定：1.普通员工，   2.各级管理人员
	private Date brithDate;  //出生日期
	private Date hireDate;   //入职时间
	private Date leaveDate;  //离职时间
	private String wagesnum; //银行卡号
	private int onDuty;      //是否在职    1.  在职     0.离职
	private String emerContactPerson;    //紧急联系人信息
	private String empDesc;  //备注信息
	private String sign;     //个性签名
	private int empcount;
	
	private Employee mgr;    //存储上级员工信息
	private Department dept; //存储部门信息
	private Position pos;    //存储岗位信息
	
	
	//构造方法
	public Employee() {
		super();
	}

	//全部构造方法
	public Employee(String empid, String password, int deptno, int posid,
			String mgrid, String empName, int empAge, String empSex,
			String empEducation, String idcard, String nation, String marry,
			String phone, String qq, String address, String email, int empType,
			Date brithDate, Date hireDate, Date leaveDate, String wagesnum,
			int onDuty, String emerContactPerson, String empDesc, Employee mgr,
			Department dept, Position pos) {
		super();
		this.empid = empid;
		this.password = password;
		this.deptno = deptno;
		this.posid = posid;
		this.mgrid = mgrid;
		this.empName = empName;
		this.empAge = empAge;
		this.empSex = empSex;
		this.empEducation = empEducation;
		this.idcard = idcard;
		this.nation = nation;
		this.marry = marry;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
		this.email = email;
		this.empType = empType;
		this.brithDate = brithDate;
		this.hireDate = hireDate;
		this.leaveDate = leaveDate;
		this.wagesnum = wagesnum;
		this.onDuty = onDuty;
		this.emerContactPerson = emerContactPerson;
		this.empDesc = empDesc;
		this.mgr = mgr;
		this.dept = dept;
		this.pos = pos;
		
	}
	
	//添加员工构造方法
	public Employee(String empid, String password, int deptno, int posid,
			String mgrid, String empName, int empAge, String empSex,
			String empEducation, String idcard, String nation, String marry,
			String phone, String qq, String address, String email, int empType,
			Date brithDate, Date hireDate, Date leaveDate, String wagesnum,
			int onDuty, String emerContactPerson, String empDesc) {
		super();
		this.empid = empid;
		this.password = password;
		this.deptno = deptno;
		this.posid = posid;
		this.mgrid = mgrid;
		this.empName = empName;
		this.empAge = empAge;
		this.empSex = empSex;
		this.empEducation = empEducation;
		this.idcard = idcard;
		this.nation = nation;
		this.marry = marry;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
		this.email = email;
		this.empType = empType;
		this.brithDate = brithDate;
		this.hireDate = hireDate;
		this.leaveDate = leaveDate;
		this.wagesnum = wagesnum;
		this.onDuty = onDuty;
		this.emerContactPerson = emerContactPerson;
		this.empDesc = empDesc;
	}
	
	//修改员构造方法
	public Employee(String empid,  int deptno, int posid,
			String mgrid,String marry,String address,int empType,
			String wagesnum, String emerContactPerson, String empDesc) {
		super();
		this.empid = empid;		
		this.deptno = deptno;
		this.posid = posid;
		this.mgrid = mgrid;		
		this.marry = marry;				
		this.address = address;	
		this.empType = empType;		
		this.wagesnum = wagesnum;		
		this.emerContactPerson = emerContactPerson;
		this.empDesc = empDesc;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getPosid() {
		return posid;
	}

	public void setPosid(int posid) {
		this.posid = posid;
	}

	public String getMgrid() {
		return mgrid;
	}

	public void setMgrid(String mgrid) {
		this.mgrid = mgrid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getEmpEducation() {
		return empEducation;
	}

	public void setEmpEducation(String empEducation) {
		this.empEducation = empEducation;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public Date getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(Date brithdate) {
		this.brithDate = brithdate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getWagesnum() {
		return wagesnum;
	}

	public void setWagesnum(String wagesnum) {
		this.wagesnum = wagesnum;
	}

	public int getOnDuty() {
		return onDuty;
	}

	public void setOnDuty(int onDuty) {
		this.onDuty = onDuty;
	}

	public String getEmerContactPerson() {
		return emerContactPerson;
	}

	public void setEmerContactPerson(String emerContactPerson) {
		this.emerContactPerson = emerContactPerson;
	}

	public String getEmpDesc() {
		return empDesc;
	}

	public void setEmpDesc(String empDesc) {
		this.empDesc = empDesc;
	}
	
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Employee getMgr() {
		return mgr;
	}

	public void setMgr(Employee mgr) {
		this.mgr = mgr;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public int getEmpcount() {
		return empcount;
	}

	public void setEmpcount(int empcount) {
		this.empcount = empcount;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", password=" + password
				+ ", deptno=" + deptno + ", posid=" + posid + ", mgrid="
				+ mgrid + ", empName=" + empName + ", empAge=" + empAge
				+ ", empSex=" + empSex + ", empEducation=" + empEducation
				+ ", idcard=" + idcard + ", nation=" + nation + ", marry="
				+ marry + ", phone=" + phone + ", qq=" + qq + ", address="
				+ address + ", email=" + email + ", empType=" + empType
				+ ", brithdate=" + brithDate + ", hireDate=" + hireDate
				+ ", leaveDate=" + leaveDate + ", wagesnum=" + wagesnum
				+ ", onDuty=" + onDuty + ", emerContactPerson="
				+ emerContactPerson + ", empDesc=" + empDesc + ", mgr=" + mgr
				+ "]";
	}


	
	
}

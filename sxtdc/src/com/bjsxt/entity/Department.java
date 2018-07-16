package com.bjsxt.entity;
/**
 * 部门
 * @author 无情
 *
 */
public class Department {

	private int deptno;       //部门编号
	private String deptName;  //部门名称
	private String deptDesc;  //部门描述
	private String location;  //部门地址
	
	//构造方法
	public Department() {
		super();
	}

	//全部属性构造方法
	public Department(int deptno, String deptName, String deptDesc,
			String location) {
		super();
		this.deptno = deptno;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.location = location;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptName=" + deptName
				+ ", deptDesc=" + deptDesc + ", location=" + location + "]";
	}
	
	
}

package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Employee;

/**
 * 员工dao 层
 * @author ZhaoWeiguang
 *
 */
public interface EmployeeDao {

	
	/**
	 * 保存员工信息到数据库
	 * @param emp
	 * @return
	 */
	int saveEmp(Employee emp);
	
	/**
	 * 查询员工功能
	 * 根据条件查询员工信息   所在部门信息  从事岗位信息
	 * @param empid   根据员工编号
	 * @param deptno   根据部门编号
	 * @param onDuty   是否在职
	 * @param hireDate  入职日期
	 * @param type     员工类型
	 * @return
	 */	
	List<Employee> findEmpByXXX(String empid, int deptno,int posid, int onDuty,String hireDate, String empName);

	/**
	 * 重置密码
	 * @param empid
	 * @return
	 */
	int pwdReset(String empid);

	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	int updateEmp(Employee emp);

	int deleteEmp(String empid);

	/**
	 * 查看上级员工信息
	 * @param type
	 * @return
	 */
	List<Employee> findEmpByType(int type);

	/**
	 * 修改密码操作
	 * @param pwd
	 * @param empid
	 * @return
	 */
	int updatePwd(String pwd, String empid);

	/**
	 * 修改个人信息
	 * @param emp
	 * @return
	 */
	int myInfoUpdate(Employee emp);

	/**
	 * 记录登录次数
	 * @param empid
	 * @param empcount
	 */
	void updateEmpCoune(String empid, int empcount);

}

package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Employee;

/**
 * 员工相关业务层
 * @author ZhaoWeiguang
 *
 */
public interface EmployeeService {
	
	/**
	 * 登录验证，根据结果返回数据
	 * @param user
	 * @param pwd
	 * @return
	 */
	Employee login(String user, String pwd);

	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	int addEmp(Employee emp);

	/**
	 * 获取上级员工信息
	 * @param i
	 * @return
	 */
	List<Employee> findEmpByType(int type);

	/**
	 * 根据条件查询员工信息
	 * @param empid
	 * @param deptno
	 * @param onDuty
	 * @param hireDate
	 * @return
	 */
	List<Employee> findEmpByXXX(String empid, int deptno,int posid, int onDuty,
			String hireDate);

	/**
	 * 密码重置功能
	 * @param empid
	 * @return
	 */
	int pwdReset(String empid);
	
	/**
	 * 根据员工编号查询员工信息
	 * @param empid
	 * @return
	 */
	Employee findEmpById(String empid);

	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	int updateEmp(Employee emp);

	/**
	 * 删除员工
	 * @param empid
	 * @return
	 */
	int deleteEmp(String empid);

	/**
	 * 修改密码
	 * @param emp
	 * @param empid
	 * @return
	 */
	int updatePwd(String pwd, String empid);

	/**
	 * 根据员工姓名查询
	 * @param empName
	 * @return
	 */
	List<Employee> findEmpByName(String empName);

	/**
	 * 利用ajax  自动获取员工姓名
	 * @param empid
	 * @return
	 */
	Employee findEmpName(String empid);

	/**
	 * 修改个人信息
	 * @param emp
	 * @return
	 */
	int myInfoUpdate(Employee emp);

	/**
	 * 修改登录次数
	 * @param user
	 * @param empcount
	 */
	void updateEmpCoune(String user, int empcount);

}

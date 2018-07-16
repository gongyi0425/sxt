package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.dao.impl.EmployeeDaoImpl;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.EmployeeService;
/**
 * 员工相关业务层实现类
 * @author ZhaoWeiguang
 *
 */
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao empDao = new EmployeeDaoImpl();
	/**
	 * 登录验证
	 */
	public Employee login(String user, String pwd) {
		List<Employee> empList = this.empDao.findEmpByXXX(user,-1,-1,-1,null,null);
		Employee emp = empList.get(0);
		if(emp == null){//用户名是错误的
			return null;
		}else{
			if(pwd!=null & pwd.equals(emp.getPassword())){
				return emp;
			}else{//用户名正确，密码错误
				return null;
			}
		}
	}

	/**
	 * 添加员工
	 */
	public int addEmp(Employee emp) {
		return this.empDao.saveEmp(emp);
	}

	/**
	 * 获取上级员工信息
	 */
	public List<Employee> findEmpByType(int type) {
		
		return this.empDao.findEmpByType(type);
	}

	/**
	 * 查询员工功能
	 * 根据条件查询员工信息
	 */
	public List<Employee> findEmpByXXX(String empid, int deptno,int posid, int onDuty,
			String hireDate) {
		return this.empDao.findEmpByXXX(empid,deptno,posid,onDuty,hireDate,null);
	}

	/**
	 * 密码重置
	 */
	public int pwdReset(String empid) {
		
		return this.empDao.pwdReset(empid);
	}

	/**
	 * 根据员工编号查询员工信息
	 */
	public Employee findEmpById(String empid) {
		int deptno = -1;  //按部门编号查询
		int posid = -1;   //按岗位编号查询
		int onDuty = -1;  //是否在职查询
		String hireDate = null;	   //入职日期查询
		String empName = null;    //员工姓名查询
		
		List<Employee> empList = this.empDao.findEmpByXXX(empid,deptno,posid,onDuty,hireDate,empName);
		Employee emp = null;
		if(empList.size()>0){
			emp = empList.get(0);
		}
		
		return emp;
		
	}

	/**
	 * 修改员工信息
	 */
	public int updateEmp(Employee emp) {
		
		return this.empDao.updateEmp(emp);
	}

	/**
	 * 删除员工
	 */
	public int deleteEmp(String empid) {
		
		return this.empDao.deleteEmp(empid);
	}


	/**
	 * 修改密码
	 */
	public int updatePwd(String pwd, String empid) {
		
		return this.empDao.updatePwd(pwd,empid);
	}
	

	/**
	 * 根据员工姓名查询
	 */
	public List<Employee> findEmpByName(String empName) {
		 
		return this.empDao.findEmpByXXX(null,-1,-1,-1,null,empName);
	}

	/**
	 * 使用
	 */
	public Employee findEmpName(String empid) {
		
		return null;
	}

	/**
	 * 修改个人信息
	 */
	public int myInfoUpdate(Employee emp) {
		
		return this.empDao.myInfoUpdate(emp);
	}

	/**
	 * 记录登录次数
	 */
	public void updateEmpCoune(String empid, int empcount) {
		
		this.empDao.updateEmpCoune(empid,empcount);
	}

	
}

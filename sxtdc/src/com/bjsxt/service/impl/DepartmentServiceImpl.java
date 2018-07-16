package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.DepartmentDao;

import com.bjsxt.dao.impl.DepartmentDaoImpl;

import com.bjsxt.entity.Department;

import com.bjsxt.service.DepartmentService;
/**
 * 部门相关操作业务层实现类
 * @author ZhaoWeiguang
 *
 */
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao deptDao = new DepartmentDaoImpl();
	
	/**
	 * 添加部门信息
	 */
	@Override
	public int addDept(Department dept) {
		return this.deptDao.saveDept(dept);
	}

	/**
	 * 查询部门信息
	 */
	@Override
	public List<Department> findAllDept() {
		return this.deptDao.findAllDept();
	}
	
	/**
	 * 更新部门信息
	 */
	@Override
	public int updateDept(Department dept) {
		return this.deptDao.updateDept(dept);
	}

	/**
	 * 更新部门预查询
	 */
	@Override
	public Department findByIdDept(int deptno) {
		return this.deptDao.findByIdDept(deptno);
	}

	/**
	 * 删除指定编号的部门信息
	 */
	@Override
	public int deleteDept(int deptno) {
		return this.deptDao.deleteDept(deptno);
	}

}

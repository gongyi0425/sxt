package com.bjsxt.service;
import java.util.List;


import com.bjsxt.entity.Department;
/**
 * 部门相关操作业务层
 * @author ZhaoWeiguang
 *
 */


public interface DepartmentService {

	/**
	 * 添加部门信息
	 * @param dept
	 * @return
	 */
	int addDept(Department dept);

	/**
	 * 查询部门信息
	 * @return
	 */
	List<Department> findAllDept();

	/**
	 * 更新部门信息
	 * @param dept
	 * @return
	 */
	int updateDept(Department dept);

	/**
	 * 更新部门预查询
	 * @param deptid
	 * @return
	 */
	Department findByIdDept(int deptno);

	/**
	 * 删除指定编号的部门信息
	 * @param deptid
	 * @return
	 */
	int deleteDept(int dept);



	


}

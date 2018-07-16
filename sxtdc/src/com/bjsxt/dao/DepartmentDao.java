package com.bjsxt.dao;
import java.util.List;


import com.bjsxt.entity.Department;
/**
 * 部门DAO
 * @author 无情
 *
 */


public interface DepartmentDao {

	/**
	 * 添加部门信息
	 * @param dept
	 * @return
	 */
	int saveDept(Department dept);

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
	int deleteDept(int deptno);


	


}

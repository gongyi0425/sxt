package com.bjsxt.dao;
/*
 * 潘培轩
 */
import java.util.List;

import com.bjsxt.entity.CustomerType;

/**
 * 客户类型dao层
 * @author ZhaoWeiguang
 *
 */
public interface CustomerTypeDao {

	/*
	 * 添加客户类型
	 */
	int saveCustomerType(CustomerType customerType);

	/*
	 * 查询所有客户类型
	 */
	List<CustomerType> findAllCustomerType();

	/*
	 * 删除客户类型
	 */
	int deleteCustomerType(int typeid);

	/*
	 * 查询指定编号的客户类型
	 */
	CustomerType findCustomerTypeById(int typeid);

	/*
	 * 更新客户类型
	 */
	int updateCustomerType(CustomerType customerType);

	/*
	 * 按条件查询客户类型(查询所有是按条件查询的一种特殊情况)
	 */
	List<CustomerType> findCustomerType(String typeName);

}

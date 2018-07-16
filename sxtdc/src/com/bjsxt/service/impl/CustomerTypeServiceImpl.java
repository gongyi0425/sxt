package com.bjsxt.service.impl;
/*
 * 潘培轩
 */
import java.util.List;

import com.bjsxt.dao.CustomerTypeDao;
import com.bjsxt.dao.impl.CustomerTypeDaoImpl;
import com.bjsxt.entity.CustomerType;
import com.bjsxt.service.CustomerTypeService;
/**
 * 客户类型 业务层实现类
 * @author ZhaoWeiguang
 *
 */
public class CustomerTypeServiceImpl implements CustomerTypeService {

	private CustomerTypeDao customerTypeDao = new CustomerTypeDaoImpl();
	
	/*
	 * 添加客户类型
	 */
	@Override
	public int addCustomerType(CustomerType customerType) {
		return this.customerTypeDao.saveCustomerType(customerType);
	}

	/*
	 * 查询所有客户类型
	 */
	@Override
	public List<CustomerType> findAllCustomerType() {
		return this.customerTypeDao.findAllCustomerType();
	}

	/*
	 * 删除客户类型
	 */
	@Override
	public int deleteCustomerType(int typeid) {
		return this.customerTypeDao.deleteCustomerType(typeid);
		
	}

	/*
	 * 查询指定编号的客户类型
	 */
	@Override
	public CustomerType findCustomerTypeById(int typeid) {
		return this.customerTypeDao.findCustomerTypeById(typeid);
	}

	/*
	 * 更新客户类型
	 */
	@Override
	public int updateCustomerType(CustomerType customerType) {
		return this.customerTypeDao.updateCustomerType(customerType);
	}

	/*
	 * 按条件查询客户类型(查询所有是按条件查询的一种特殊情况)
	 */
	@Override
	public List<CustomerType> findCustomerType(String typeName) {
		return this.customerTypeDao.findCustomerType(typeName);
	}

}

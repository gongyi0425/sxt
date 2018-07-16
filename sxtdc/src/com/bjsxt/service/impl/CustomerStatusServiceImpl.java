package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.CustomerStatusDao;
import com.bjsxt.dao.impl.CustomerStatusDaoImpl;
import com.bjsxt.entity.CustomerStatus;
import com.bjsxt.service.CustomerStatusService;
/**
 * 客户状态  业务层实现类
 * @author ZhaoWeiguang
 *
 */
public class CustomerStatusServiceImpl implements CustomerStatusService {
	
	CustomerStatusDao statusDao = new CustomerStatusDaoImpl();
	
	/**
	 * 查询所有客户状态
	 */
	@Override
	public List<CustomerStatus> findAllStatus() {
		return this.statusDao.findAllStatus();
	}
	/**
	 * 添加客户状态
	 */
	@Override
	public int addStatus(CustomerStatus status) {
		return this.statusDao.addStatus(status);
	}
	/**
	 * 更新客户信息预查询
	 */
	@Override
	public CustomerStatus findByIdStatus(int staid) {
		return this.statusDao.findByIdStatus(staid);
	}
	/**
	 * 更新客户状态
	 */
	@Override
	public int updateStatus(CustomerStatus status) {
		return this.statusDao.updateStatus(status);
	}
	/**
	 * 删除指定编号的客户状态
	 */
	@Override
	public int deleteStatus(int staid) {
		return this.statusDao.deleteStatus(staid);
		
	}
	/**
	 * 查询指定编号的客户状态
	 */
	@Override
	public List<CustomerStatus> findStatus(String staName) {
		return this.statusDao.findStatus(staName);
	}

}

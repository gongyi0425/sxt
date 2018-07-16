package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.CustomerSourceDao;
import com.bjsxt.dao.impl.CustomerSourceDaoImpl;
import com.bjsxt.entity.CustomerSource;
import com.bjsxt.service.CustomerSourceService;
/**
 * 客户来源业务层实现类
 * @author ZhaoWeiguang
 *
 */
public class CustomerSourceServiceImpl implements CustomerSourceService {

	CustomerSourceDao sourceDao = new CustomerSourceDaoImpl();
	/**
	 * 添加客户来源
	 */
	@Override
	public int addSource(CustomerSource source) {
		return this.sourceDao.addSource(source);
	}
	/**
	 * 查询所有客户来源信息
	 */
	@Override
	public List<CustomerSource> findAllSource() {
		return this.sourceDao.findAllSource();
	}
	/**
	 * 更新客户来源信息预查询
	 */
	@Override
	public CustomerSource findByIdSource(int souid) {
		return this.sourceDao.findByIdSource(souid);
	}
	/**
	 * 更新客户来源信息
	 */
	@Override
	public int updateSource(CustomerSource source) {
		return this.sourceDao.updateSource(source);
	}
	/**
	 * 删除指定编号的客户来源信息
	 */
	@Override
	public int deleteSource(int souid) {
		return this.sourceDao.deleteSource(souid);
	}
	/**
	 * 根据条件查询客户来源信息
	 */
	@Override
	public List<CustomerSource> findSource(String souName) {
		return this.sourceDao.findSource(souName);
	}

}

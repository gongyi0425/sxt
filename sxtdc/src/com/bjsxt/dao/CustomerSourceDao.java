package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.CustomerSource;

/**
 * 客户来源 dao层
 * @author ZhaoWeiguang
 *
 */
public interface CustomerSourceDao {

	/**
	 * 添加客户来源
	 * @param source
	 * @return
	 */
	int addSource(CustomerSource source);

	/**
	 * 查询所有客户来源信息
	 * @return
	 */
	List<CustomerSource> findAllSource();

	/**
	 * 更新客户来源信息预查询
	 * @param souid
	 * @return
	 */
	CustomerSource findByIdSource(int souid);

	/**
	 * 更新客户来源信息
	 * @param source
	 * @return
	 */
	int updateSource(CustomerSource source);

	/**
	 * 删除指定编号的客户来源信息
	 * @param souid
	 * @return
	 */
	int deleteSource(int souid);

	/**
	 * 根据条件查询客户来源信息
	 * @param souName
	 * @return
	 */
	List<CustomerSource> findSource(String souName);

}

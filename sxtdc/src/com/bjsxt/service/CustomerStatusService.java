package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.CustomerStatus;

/**
 * 客户状态业务层
 * @author ZhaoWeiguang
 *
 */
public interface CustomerStatusService {

	/**
	 * 查询所有客户状态
	 * @return
	 */
	List<CustomerStatus> findAllStatus();
	/**
	 * 添加客户状态
	 * @param status
	 * @return
	 */
	int addStatus(CustomerStatus status);
	/**
	 * 更新客户状态预查询
	 * @param staid
	 * @return
	 */
	CustomerStatus findByIdStatus(int staid);
	/**
	 * 更新客户状态
	 * @param status
	 * @return
	 */
	int updateStatus(CustomerStatus status);
	/**
	 * 删除指定编号的客户状态
	 * @param staid
	 */
	int deleteStatus(int staid);
	/**
	 * 查询指定编号的客户状态
	 * @param staName
	 * @return
	 */
	List<CustomerStatus> findStatus(String staName);

}

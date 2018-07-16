package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Customer;

/**
 * 客户dao层
 * @author ZhaoWeiguang
 *
 */
public interface CustomerDao {

	/**
	 * 保存客户信息到数据库
	 * @param cus
	 * @return
	 */
	int saveCus(Customer cus);

	/**
	 * 根据条件查询客户信息
	 * @param cusName
	 * @param staid
	 * @param souid
	 * @param typeid
	 * @param empid
	 * @param cusCompany
	 * @return
	 */
	List<Customer> findCusByXXX(String cusName, String staName, String souName,
			String typeName, String empid, String cusCompany,int cusid,int allot);

	/**
	 * 删除客户
	 * @param cusid
	 * @return
	 */
	int deleteCus(int cusid);

	/**
	 * 修改客户信息
	 * @param cus
	 * @return
	 */
	int updateCus(Customer cus);

	/**
	 * 客户分配
	 * @param cusid
	 * @param empid
	 * @return
	 */
	int allotCus(int cusid, String empid);

	/**
	 * 客户分布图显示
	 * @return
	 */
	List<Object[]> getAreaData();

}

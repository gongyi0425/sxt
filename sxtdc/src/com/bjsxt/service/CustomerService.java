package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Area;
import com.bjsxt.entity.Customer;

/**
 * 客户信息
 * @author zhaoWeiGuang
 *
 */
public interface CustomerService {

	/**
	 * 添加客户
	 * @param cus
	 * @return
	 */
	int addCus(Customer cus);

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
			String typeName, String empid, String cusCompany,int allot);

	/**
	 * 查看员工详细信息
	 * @param cusid
	 * @return
	 */
	Customer findCusById(int cusid);

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
	 * 根据客户姓名查找
	 * @param empName
	 * @return
	 */
	List<Customer> findCusByName(String empName);

	/**
	 * 获得地区信息
	 * @param parentID
	 * @return
	 */
	List<Area> getAreaInfo(int parentID);

	/**
	 * 根据  省  市  县 的编号 获得对应的名称
	 * @param province2
	 * @return
	 */
	String findAreaName(int province2);

	/**
	 * 客户分布图显示
	 * @return
	 */
	String getAreaData();

}

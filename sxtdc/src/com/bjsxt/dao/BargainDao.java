package com.bjsxt.dao;

import java.util.Date;
import java.util.List;

import com.bjsxt.entity.Bargain;

/**
 * 交易Dao层
 * @author zhujiaming
 *
 */
public interface BargainDao {
	
	/**
	 * 添加交易
	 * @param bargain
	 * @return
	 */
	int addBargain(Bargain bargain);
	/**
	 * 查询所有交易
	 * @param query 
	 * @param squery 
	 * @param queryType 
	 * @return
	 */
	List<Bargain> findByIdBargain(String query, Date squery, int queryType);
	/**
	 * 删除指定编号的交易
	 * @param barid
	 * @return
	 */
	int deleteBargain(int barid);
	/**
	 * 查看交易详细信息
	 * @param barid
	 * @return
	 */
	Bargain findBarInfo(int barid);
	

	
	/**
	 * 查询我的交易单
	 * @param barid
	 * @param cusName
	 * @param area
	 * @param totalPrice
	 * @return
	 */
	List<Bargain> findBarByEmpid(int barid, String cusName, double area,
			double totalPrice,String empid);

}

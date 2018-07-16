package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.AreaDao;
import com.bjsxt.dao.CustomerDao;
import com.bjsxt.dao.impl.AreaDaoImpl;
import com.bjsxt.dao.impl.CustomerDaoImpl;
import com.bjsxt.entity.Area;
import com.bjsxt.entity.Customer;
import com.bjsxt.service.CustomerService;
/**
 * 客户相关 业务层实现类
 * @author ZhaoWeiguang
 *
 */
public class CustomerServiceImpl implements CustomerService{

	private CustomerDao cusDao = new CustomerDaoImpl();
	private AreaDao areaDao = new AreaDaoImpl();
	
	/**
	 * 添加客户
	 */
	public int addCus(Customer cus) {
		
		return this.cusDao.saveCus(cus);
	}

	/**
	 * 根据条件查询客户信息
	 */
	public List<Customer> findCusByXXX(String cusName, String staName,
			String souName, String typeName, String empid, String cusCompany,int allot) {
		
		return  this.cusDao.findCusByXXX(cusName,staName,souName,typeName,empid,cusCompany,0,allot);
	}

	/**
	 * 查看员工详细信息
	 */
	public Customer findCusById(int cusid) {
		List<Customer> cusList = this.cusDao.findCusByXXX(null,null,null,null,null,null,cusid,-1);
		Customer cus = cusList.get(0);
		return cus;
	}

	/**
	 * 删除客户
	 */
	public int deleteCus(int cusid) {
		
		return this.cusDao.deleteCus(cusid);
	}

	/**
	 * 修改客户信息
	 */
	public int updateCus(Customer cus) {
		
		return this.cusDao.updateCus(cus);
	}

	/**
	 * 客户分配
	 */
	public int allotCus(int cusid, String empid) {
		
		return this.cusDao.allotCus(cusid,empid);
	}
	
	/**
	 * 根据客户姓名查找
	 */	
	public List<Customer> findCusByName(String cusName) {
		return this.cusDao.findCusByXXX(cusName,null,null,null,null,null,-1,-1);
	}

	/**
	 * 获得区域信息
	 */
	public List<Area> getAreaInfo(int parentID) {
		
		return this.areaDao.findAreaById(parentID);
	}

	/**
	 * 根据  省  市  县 的编号 获得对应的名称
	 */
	public String findAreaName(int areaid) {
		
		return this.areaDao.findAreaName(areaid);
	}

	/**
	 * 客户分布图显示
	 */
	public String getAreaData() {
		
		//调用DAO层获取收入数据（List）
		
		List<Object []> areaList = this.cusDao.getAreaData();
		
		//将List转换成jsonStr 
		
//		String a = "北京";
//	    jsonStr.append("{\"value\":"+arr[1]+",\"name\":\""+arr[0]+"\"");
//		jsonStr.append("{\"value\":"+300+",\"name\":\""+a+"\"");
		StringBuilder strArr = new StringBuilder("[");
		for(int i=0;i<areaList.size();i++){
			Object[] arr = areaList.get(i);
			strArr.append("{\"value\":"+arr[1]+",\"name\":\""+arr[0]+"\"");
			
			if(i<areaList.size()-1){
				strArr.append("},");
			}else{
				strArr.append("}");
			}
			
			
			
		}
		strArr.append("]");
		
		
		return strArr.toString();
	}



	
}

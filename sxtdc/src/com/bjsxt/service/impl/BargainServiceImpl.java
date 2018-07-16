package com.bjsxt.service.impl;

import java.util.Date;
import java.util.List;

import com.bjsxt.dao.BargainDao;
import com.bjsxt.dao.HouseDao;
import com.bjsxt.dao.impl.BargainDaoImpl;
import com.bjsxt.dao.impl.HouseDaoImpl;
import com.bjsxt.entity.Bargain;
import com.bjsxt.service.BargainService;

/**
 * 交易
 * @author zhujiaming
 *
 */
public class BargainServiceImpl implements BargainService{

	BargainDao bargainDao = new BargainDaoImpl();
	/**
	 * 添加交易
	 */
	@Override
	public int addBargain(Bargain bargain) {
		int a = this.bargainDao.addBargain(bargain);
		int hoousid= bargain.getHouseid();
		HouseDao houseDao = new HouseDaoImpl();
		int b = houseDao.updateHouseState(hoousid);
		int num = 0;
		if(a>0&&b>0){
			num=1;
		}
		return num;
	}
	/**
	 * 查询所有交易
	 */
	@Override
	public List<Bargain> findByIdBargain(String query, Date squery, int queryType) {
		return this.bargainDao.findByIdBargain(query,squery,queryType);
	}
	/**
	 * 删除指定编号的交易
	 */
	@Override
	public int deleteBargain(int barid) {
		return this.bargainDao.deleteBargain(barid);
		
	}
	/**
	 * 查看交易详细信息
	 */
	@Override
	public Bargain findBarInfo(int barid) {
		return this.bargainDao.findBarInfo(barid);
	}



	/**
	 * 查询我的交易单
	 */
	public List<Bargain> findBarByEmpid(int barid, String cusName, double area,
			double totalPrice,String empid) {
		
		return this.bargainDao.findBarByEmpid(barid,cusName,area,totalPrice,empid);
	}
		

}

package com.bjsxt.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bjsxt.dao.HouseDao;
import com.bjsxt.dao.HouseImgDao;
import com.bjsxt.dao.impl.HouseDaoImpl;
import com.bjsxt.dao.impl.HouseImgDaoImpl;

import com.bjsxt.entity.House;
import com.bjsxt.entity.HouseImg;
import com.bjsxt.service.HouseService;
import com.bjsxt.util.DBUtilService;
import com.bjsxt.util.MyException;


/**
 * 房屋信息
 * @author ZhaoWeiGuang
 *
 */
public class HouseServiceImpl implements HouseService{

	private HouseDao houseDao = new HouseDaoImpl();
	private HouseImgDao imgDao = new HouseImgDaoImpl();
	
	/*
	 * 添加房屋信息
	 */
	@Override
	public int addHouse(House house) {
		return this.houseDao.save(house);
	}

	/*
	 * 查询所有房屋信息
	 */
	@Override
	public List<House> findAllHouse() {
		return this.houseDao.findAllHouse();
	}

	/*
	 * 按条件查询房屋信息（查询所有是按条件查询的一种特殊形式）
	 */
	@Override
	public List<House> findHouse(String location, int typeid, String housestate) {
		return this.houseDao.findHouse(location,typeid,housestate);
	}
	/**
	 * 查询房屋功能
	 */
	@Override
	public List<House> findHouseName(int houName, String typeName, double price) {
		return this.houseDao.findHouseName(houName,typeName,price);
	}

	/*
	 * 删除房屋
	 */
	@Override
	public int deleteHouse(int houseid) {
		return this.houseDao.deleteHouse(houseid);
	}

	/*
	 * 查询指定编号的房屋信息
	 */
	@Override
	public House findHouseById(int houseid) {
		return this.houseDao.findHouseById(houseid);
	}

	/*
	 * 更新房屋信息
	 */
	@Override
	public int updateHouse(House house) {
		return this.houseDao.updateHouse(house);
	}

	/**
	 * ==========================================================================
	 * 添加房屋信息
	 */
	public void addHou(House hou) {
		//得到房屋编号的下一个值  起始值1000 
		int housid = this.houseDao.nextVal();		
		hou.setHouseid(housid);     //设置房屋编号				
		 //开启事务		 
		Connection conn = DBUtilService.getConnection(); //建立数据库的连接
		try {
			conn.setAutoCommit(false);//设置数据不自动提交						
			 //保存房屋信息到数据库			 				
			this.houseDao.saveHou(hou);						
			 //保存房屋图片到数据库			 
			List<HouseImg> itemList = hou.getImgList();
			System.out.println(itemList.size());
				
			for(int i = 0; i<itemList.size();i++){
				HouseImg houseImg = itemList.get(i);
				houseImg.setHouseid(housid);
				this.imgDao.saveImg(houseImg);
			}									
			 //提交或者回滚事务 			 
			conn.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();//出现异常回滚数据
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new MyException(e1.toString());//出现异常向上级（调用者）抛出
			}
			throw new MyException(e.toString());//出现异常向上级（调用者）抛出
		}finally{
			DBUtilService.closeAll(null, null, conn);
		}
	}

	/**
	 * 根据房屋编号查询图片
	 */
	public List<HouseImg> findImgByHouseId(int houseid) {
		
		return this.imgDao.findImgByHouseId(houseid);
	}

	/**
	 * 下载图片
	 */
	public HouseImg findByImgId(int imgid) {
		
		return this.imgDao.findByImgId(imgid);
	}

	
}

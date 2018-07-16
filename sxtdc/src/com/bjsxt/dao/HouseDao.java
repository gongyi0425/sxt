package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.House;

/**
 * 房屋DAO
 * @author 潘培轩
 *
 */
public interface HouseDao {

	/*
	 * 添加房屋信息
	 */
	int save(House house);

	/*
	 * 查询所有房屋信息
	 */
	List<House> findAllHouse();

	/*
	 * 按条件查询房屋信息（查询所有是按条件查询的一种特殊形式）
	 */
	List<House> findHouse(String location, int typeid, String housestate);
	/**
	 * 查询房屋功能
	 * @param houName
	 * @param price 
	 * @param typeName 
	 * @return
	 */
	List<House> findHouseName(int houName, String typeName, double price);

	/*
	 * 删除房屋
	 */
	int deleteHouse(int houseid);

	/*
	 * 查询指定编号的房屋信息
	 */
	House findHouseById(int houseid);

	/*
	 * 更新房屋信息
	 */
	int updateHouse(House house);

	/**
	 * 获取房屋的编号
	 * @return
	 */
	int nextVal();

	/**
	 * 保存房屋信息到数据库
	 * @param hou
	 */
	void saveHou(House hou);

	/**
	 * 修改房屋状态
	 * @param hoousid
	 * @return
	 */
	int updateHouseState(int hoousid);

}

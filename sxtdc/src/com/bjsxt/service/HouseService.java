package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.House;
import com.bjsxt.entity.HouseImg;

/**
 * 房屋信息
 * @author 潘培轩
 *
 */
public interface HouseService {

	/*
	 * 添加房屋信息
	 */
	int addHouse(House house);

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
	 * 添加房屋信息
	 * @param hou
	 * @return
	 */
	void addHou(House hou);

	/**
	 * 根据房屋编号查询图片
	 * @return
	 */
	List<HouseImg> findImgByHouseId(int houseid);

	/**
	 * 下载图片
	 * @param imgid
	 * @return
	 */
	HouseImg findByImgId(int imgid);

}

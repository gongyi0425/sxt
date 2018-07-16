package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.HouseType;

/**
 * 房屋类型  业务层
 * @author 潘培轩
 *
 */
public interface HouseTypeService {

	/*
	 * 添加房屋类型
	 */
	int addHouseType(HouseType houseType);

	/*
	 * 查询所有房屋类型
	 */
	List<HouseType> findAllHouseType();

	/*
	 * 按条件查询房屋类型(查询所有是按条件查询的一种特殊情况)
	 */
	List<HouseType> findHouseType(String typeName);

	/*
	 * 删除房屋类型
	 */
	int deleteHouseType(int typeid);

	/*
	 * 查询指定编号的房屋类型
	 */
	HouseType findHouseTypeById(int typeid);

	/*
	 * 更新房屋类型
	 */
	int updateHouseType(HouseType houseType);


}

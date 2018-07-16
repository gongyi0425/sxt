package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.HouseTypeDao;
import com.bjsxt.dao.impl.HouseTypeDaoImpl;
import com.bjsxt.entity.HouseType;
import com.bjsxt.service.HouseTypeService;
/**
 * 房屋类型  业务层实现类
 * @author 潘培轩
 *
 */
public class HouseTypeServiceImpl implements HouseTypeService {

	private HouseTypeDao houseTypeDao = new HouseTypeDaoImpl();
	
	/*
	 * 添加房屋类型
	 */
	@Override
	public int addHouseType(HouseType houseType) {
		return this.houseTypeDao.save(houseType);
	}

	/*
	 * 查询所有房屋类型
	 */
	@Override
	public List<HouseType> findAllHouseType() {
		return this.houseTypeDao.findAllHouseType();
	}

	/*
	 * 按条件查询房屋类型(查询所有是按条件查询的一种特殊情况)
	 */
	@Override
	public List<HouseType> findHouseType(String typeName) {
		return this.houseTypeDao.findHouseType(typeName);
	}

	/*
	 * 删除房屋类型
	 */
	@Override
	public int deleteHouseType(int typeid) {
		return this.houseTypeDao.deleteHouseType(typeid);
	}

	/*
	 * 查询指定编号的房屋类型
	 */
	@Override
	public HouseType findHouseTypeById(int typeid) {
		return this.houseTypeDao.findHouseTypeById(typeid);
	}

	
	/*
	 * 更新房屋类型
	 */
	@Override
	public int updateHouseType(HouseType houseType) {
		return this.houseTypeDao.updateHouseType(houseType);
	}

}

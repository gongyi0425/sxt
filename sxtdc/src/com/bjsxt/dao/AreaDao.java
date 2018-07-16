package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Area;

public interface AreaDao {

	/**
	 * 根据编号获得区域信息
	 * @param parentID
	 * @return
	 */
	List<Area> findAreaById(int parentID);

	/**
	 * 根据  省  市  县 的编号 获得对应的名称
	 * @param areaid
	 * @return
	 */
	String findAreaName(int areaid);

	/**
	 * 客户分布图显示
	 * @return
	 */
	String getAreaData();

}

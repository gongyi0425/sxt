package com.bjsxt.test;

import org.junit.Test;

import com.bjsxt.entity.HouseType;
import com.bjsxt.service.HouseTypeService;
import com.bjsxt.service.impl.HouseTypeServiceImpl;

public class TestHouseTypeService {
	
	@Test
	public void TestFindById(){
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		HouseType houseType = houseTypeService.findHouseTypeById(1);
		System.out.println(houseType);
	}
}

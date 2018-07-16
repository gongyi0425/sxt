package com.bjsxt.test;

import java.util.List;

import org.junit.Test;

import com.bjsxt.entity.CustomerType;
import com.bjsxt.entity.Position;
import com.bjsxt.service.CustomerTypeService;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.CustomerTypeServiceImpl;
import com.bjsxt.service.impl.PositionServiceImpl;

public class TestCustomerTypeService {

	@Test
	public void TestFindAll(){
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
		System.out.println(customerTypeList.size());
	}
	
	@Test
	public void TestFindById(){
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		CustomerType customerType = customerTypeService.findCustomerTypeById(1);
		System.out.println(customerType);
	}
	
	@Test
	public void TestFindCustomerType(){
		CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
		List<CustomerType> customerType = customerTypeService.findCustomerType("望子成龙");
		System.out.println(customerType);
	}
}

package com.bjsxt.service.impl;

import com.bjsxt.dao.CustomerProvinceDao;
import com.bjsxt.dao.impl.CustomerProvinceDaoImpl;
import com.bjsxt.service.CustomerProvinceService;

public class CustomerProvinceImpl implements CustomerProvinceService{
	private CustomerProvinceDao customerProvinceDao = new CustomerProvinceDaoImpl();
	@Override
	public String customerProvince() {
		return this.customerProvinceDao.countProvince();
	}

}

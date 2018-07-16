package com.bjsxt.service.impl;

import java.util.Date;
import java.util.List;

import com.bjsxt.dao.LogDao;
import com.bjsxt.dao.impl.LogDaoImpl;
import com.bjsxt.entity.Log;
import com.bjsxt.service.LogService;

public class LogServiceImpl implements LogService {
	private int count;
	@Override
	public void setCountIntoDao(int c) {
		//获取dao层对象
		LogDao ld = new LogDaoImpl();
		//调用方法--保存数据
		ld.setCountIntoData(c);
		
	}

	@Override
	public int getCountIntoDao() {
		//获取dao层对象
		LogDao ld = new LogDaoImpl();
		//调用方法---获取数据
		count = ld.getCountIntoData();
		return count;
	}

	@Override
	public void setLogIntoDao(Log log) {
		//获取dao层对象
			LogDao ld = new LogDaoImpl();
		//调用方法--保存数据
			ld.setLogIntoData(log);
		
	}

	@Override
	public List<Log> getLogIntoDao(String starttime,String endtime) {
		//获取dao层对象
			LogDao ld = new LogDaoImpl();
		//调用方法---获取数据
			List<Log> log = ld.getLogIntoData(starttime,endtime);
		return log;
	}

}

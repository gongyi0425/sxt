package com.bjsxt.service;

import java.util.Date;
import java.util.List;

import com.bjsxt.entity.Log;

public interface LogService {

	void setCountIntoDao(int count);

	int getCountIntoDao();

	void setLogIntoDao(Log log);
	
	List<Log> getLogIntoDao(String starttime,String endtime);

}

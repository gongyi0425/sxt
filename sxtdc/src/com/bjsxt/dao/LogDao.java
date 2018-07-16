package com.bjsxt.dao;

import java.util.Date;
import java.util.List;

import com.bjsxt.entity.Log;

public interface LogDao {

	void setCountIntoData(int c);

	int getCountIntoData();

	void setLogIntoData(Log log);

	List<Log> getLogIntoData(String starttime,String endtime);

}

package com.bjsxt.test;
/*
 * 潘培轩
 */
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bjsxt.entity.Log;
import com.bjsxt.entity.Position;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.PositionServiceImpl;


public class TestPositionService {
	
	@Test
	public void TestAdd(){
		PositionService positionService = new PositionServiceImpl();
		Position position = new Position(1, "销售专员", "负责房屋销售");
		int n = positionService.addPos(position);
		System.out.println(n);
	}
	
	@Test
	public void TestFindAll(){
		PositionService positionService = new PositionServiceImpl();
		List<Position> positionList = positionService.findAllPos();
		System.out.println(positionList.size());
	}
	
	
	@Test
	public void TestFindById(){
//		PositionService positionService = new PositionServiceImpl();
//		Position position = positionService.findPosById(1);
//		System.out.println(position);
		Log log = new Log();
		System.out.println(log);
	}
	
	
}

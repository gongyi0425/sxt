package com.bjsxt.service.impl;


import java.util.List;

import com.bjsxt.dao.PositionDao;
import com.bjsxt.dao.impl.PositionDaoImpl;
import com.bjsxt.entity.Position;
import com.bjsxt.service.PositionService;
/**
 * 岗位相关操作业务层实现类
 * @author ZhaoWeiguang
 *
 */
public class PositionServiceImpl implements PositionService {
	
	private PositionDao posDao = new PositionDaoImpl();
	
	/*
	 * 添加岗位
	 */
	@Override
	public int addPos(Position position) {
		return this.posDao.savePos(position);
	}
	
	/*
	 * 查询所有岗位信息
	 */
	@Override
	public List<Position> findAllPos() {
		return this.posDao.findAllPos();
	}
	
	/*
	 * 删除岗位
	 */
	@Override
	public int deletePos(int posid) {
		return this.posDao.deletePos(posid);
	}
	
	/*
	 * 查询指定编号的岗位
	 */
	@Override
	public Position findPosById(int posid) {
		return this.posDao.findPosById(posid);
	}
	
	/*
	 * 更新岗位
	 */
	@Override
	public int updatePos(Position position) {
		return this.posDao.updatePos(position);
	}

}

package com.bjsxt.service;
import java.util.List;

/*
 * 潘培轩
 */
import com.bjsxt.entity.Position;
/**
 * 岗位相关操作业务层
 * @author ZhaoWeiguang
 *
 */
public interface PositionService {

	/*
	 * 添加岗位
	 */
	int addPos(Position position);

	/*
	 * 查询所有岗位信息
	 */
	List<Position> findAllPos();

	/*
	 * 删除岗位
	 */
	int deletePos(int posid);

	/*
	 * 查询指定编号的岗位
	 */
	Position findPosById(int posid);

	/*
	 * 更新岗位
	 */
	int updatePos(Position position);

}

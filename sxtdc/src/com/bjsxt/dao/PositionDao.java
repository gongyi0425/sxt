package com.bjsxt.dao;
import java.util.List;

/*
 * 潘培轩
 */
import com.bjsxt.entity.Position;

public interface PositionDao {

	/*
	 * 添加岗位
	 */
	int savePos(Position position);

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

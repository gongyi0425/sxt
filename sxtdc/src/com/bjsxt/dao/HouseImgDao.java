package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.HouseImg;

/**
 * 房屋图片dao
 * @author ZhaoWeiGuang
 *
 */
public interface HouseImgDao {

	/**
	 * 保存图片到数据库
	 * @param img
	 */
	void saveImg(HouseImg img);

	/**
	 * 根据房屋编号查询图片
	 * @param houseid
	 * @return
	 */
	List<HouseImg> findImgByHouseId(int houseid);

	/**
	 * 下载图片
	 * @param imgid
	 * @return
	 */
	HouseImg findByImgId(int imgid);

}

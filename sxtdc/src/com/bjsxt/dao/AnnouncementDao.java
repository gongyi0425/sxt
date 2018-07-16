package com.bjsxt.dao;

import java.util.Date;
import java.util.List;

import com.bjsxt.entity.Announcement;

/**
 * 公告DAO
 * @author 无情
 *
 */
public interface AnnouncementDao {

	/**
	 * 添加公告
	 * @param ann
	 * @return
	 */
	public int addAnn(Announcement ann);
	/**
	 * 查询所有公告;查询指定编号的公告
	 * @param city 
	 * @param query 
	 * @return
	 */
	public List<Announcement> findAllAnn(String query, Date city);
	/**
	 * 更新公告预查询
	 * @param annid
	 * @return
	 */
	public Announcement findByIdAnn(int annid);
	/**
	 * 更新公告
	 * @param ann
	 * @return
	 */
	public int updateAnn(Announcement ann);
	/**
	 * 删除公告
	 * @param annid
	 * @return
	 */
	public int deleteAnn(int annid);

}

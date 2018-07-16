package com.bjsxt.service;

import java.util.Date;
import java.util.List;

import com.bjsxt.entity.Announcement;

/**
 * 公告
 * @author 无情
 *
 */
public interface AnnouncementService {
	
	/**
	 * 添加公告
	 * @author 
	 */
	int addAnn(Announcement ann);
	/**
	 * 查询所有公告;查询指定编号的公告
	 * @param city 
	 * @param query 
	 * @return
	 */
	List<Announcement> findAllAnn(String query, Date city);
	/**
	 * 更新公告预查询
	 * @param annid
	 * @return
	 */
	Announcement findByIdAnn(int annid);
	/**
	 * 更新公告
	 * @param ann
	 * @return
	 */
	int updateAnn(Announcement ann);
	/**
	 * 删除公告
	 * @param annid
	 */
	int deleteAnn(int annid);
	
}

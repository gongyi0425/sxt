package com.bjsxt.service.impl;

import java.util.Date;
import java.util.List;

import com.bjsxt.dao.AnnouncementDao;
import com.bjsxt.dao.impl.AnnouncementDaoImpl;
import com.bjsxt.entity.Announcement;
import com.bjsxt.service.AnnouncementService;

/**
 * 公告
 * @author 无情
 *
 */
public class AnnouncementServiceImpl implements AnnouncementService{
	private AnnouncementDao annDao = new AnnouncementDaoImpl();
	/**
	 * 添加公告
	 * @author zhujiaming
	 */
	@Override
	public int addAnn(Announcement ann) {
		return this.annDao.addAnn(ann);
	}
	/**
	 * 查询所有公告
	 */
	@Override
	public List<Announcement> findAllAnn(String query, Date city) {
		return this.annDao.findAllAnn(query,city);
	}
	/**
	 * 更新公告预查询
	 */
	@Override
	public Announcement findByIdAnn(int annid) {
		return this.annDao.findByIdAnn(annid);
	}
	/**
	 * 更新公告
	 */
	@Override
	public int updateAnn(Announcement ann) {
		return this.annDao.updateAnn(ann);
	}
	/**
	 * 删除公告
	 */
	@Override
	public int deleteAnn(int annid) {
		return this.annDao.deleteAnn(annid);
	}
	

}

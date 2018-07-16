package com.bjsxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bjsxt.dao.AnnouncementDao;
import com.bjsxt.dao.impl.AnnouncementDaoImpl;
import com.bjsxt.entity.Announcement;


/**
 * 测试  公告
 * @author 无情
 *
 */
public class TestAnnouncement {
	/**
	 * 测试添加公告	
	 * 
	 * 成功
	 * 
	 * @author 无情
	 */
	public static void main(String[] args) {
		AnnouncementDao announcementDao = new AnnouncementDaoImpl();
		String anntime = "1999-9-9";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date anntime1 = null;
		try{
			anntime1 = df.parse(anntime);
		} catch(ParseException e){
			System.out.println("以下是捕获的异常");
			e.printStackTrace();
		}
		String annendtime = "2000-2-2";
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		Date annendtime1 = null;
		try{
			annendtime1 = df2.parse(annendtime);
		} catch(ParseException e){
			System.out.println("以下是捕获的异常");
			e.printStackTrace();
		}
		
		Announcement announcement = new Announcement(1000101010,"测试","测试",anntime1,annendtime1);
		//int n = announcementDao.saveAnn(announcement);
		//System.out.println(n);
	}
}			
			
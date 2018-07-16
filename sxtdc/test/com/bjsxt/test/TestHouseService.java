package com.bjsxt.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.bjsxt.entity.AnalyzeReview;
import com.bjsxt.entity.Customer;
import com.bjsxt.entity.CustomerReview;
import com.bjsxt.entity.House;
import com.bjsxt.service.AnalyzeAttentionService;
import com.bjsxt.service.AnalyzeReviewService;
import com.bjsxt.service.CustomerReviewService;
import com.bjsxt.service.CustomerService;
import com.bjsxt.service.HouseService;
import com.bjsxt.service.impl.AnalyzeAttentionServiceImpl;
import com.bjsxt.service.impl.AnalyzeReviewServiceImpl;
import com.bjsxt.service.impl.CustomerReviewServiceImpl;
import com.bjsxt.service.impl.CustomerServiceImpl;
import com.bjsxt.service.impl.HouseServiceImpl;

public class TestHouseService {

/*	@Test
	public void TestFindById(){
		HouseService houseService = new HouseServiceImpl();
		List<House> houseList = houseService.findHouse("507",1,"未交易");	
		System.out.println(houseList);
	}
	
	
	@Test
	public void findHouseById(){
		HouseService houseService = new HouseServiceImpl();
		House house = houseService.findHouseById(1);
		System.out.println(house);
	}
	*/
	/*@Test
	public void findCustomerById(){
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = customerService.findCusById(1080);
		System.out.println(customer);	
	}*/
	
	/*@Test
	public void findCustomerReviewId(){
		CustomerReviewService reviewService = new CustomerReviewServiceImpl();
		List<CustomerReview> reviewList = reviewService.findAllReview();
		for (Iterator iterator = reviewList.iterator(); iterator.hasNext();) {
			CustomerReview customerReview = (CustomerReview) iterator.next();
			System.out.println(customerReview.getReviewId()+"----"+customerReview.getReviewName()+"----"+customerReview.getReviewDesc());
		}
	}*/
	@Test
	public void analyzeReview(){
		AnalyzeAttentionService testService = new AnalyzeAttentionServiceImpl();
		String analyzeAttention = testService.analyzeAttention();
		System.out.println(analyzeAttention);
		
	}
	
}

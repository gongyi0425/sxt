package com.bjsxt.service.impl;

import com.bjsxt.dao.AnalyzeAttentionDao;
import com.bjsxt.dao.impl.AnalyzeAttentionDaoImpl;
import com.bjsxt.service.AnalyzeAttentionService;

public class AnalyzeAttentionServiceImpl implements AnalyzeAttentionService{
	AnalyzeAttentionDao analyzeAttentionDao = new AnalyzeAttentionDaoImpl();
	@Override
	public String analyzeAttention() {
		return this.analyzeAttentionDao.analyzeAttention();
	}

}

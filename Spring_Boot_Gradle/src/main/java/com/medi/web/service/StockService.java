package com.medi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.medi.web.constant.GlobalConstant;
import com.medi.web.exception.BusinessException;
import com.medi.web.model.StockMaster;
import com.medi.web.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private Environment properties;
	@Autowired
	private StockRepository stockRepository;
	
	public void addStock(final StockMaster stockMaster) throws BusinessException
	{
		try {
			stockRepository.save(stockMaster);
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_CODE),properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_DETAILS));
		}
	}
	
	public StockMaster getStock(String comName) throws BusinessException
	{
		StockMaster getStockInfo=null;
		try {
			getStockInfo=stockRepository.getStockByCompanyName(comName);
			return getStockInfo;
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_CODE),properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_DETAILS));
		}
	}
	
	public List<StockMaster> getAllStock() throws BusinessException
	{
		List<StockMaster> getStockInfoList=null;
		try {
			getStockInfoList=stockRepository.findAll();
			return getStockInfoList;
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_CODE),properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_DETAILS));
		}
	}

}

package com.medi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.web.model.StockMaster;
import com.medi.web.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	public void addStock(final StockMaster stockMaster)
	{
		stockRepository.save(stockMaster);
	}
	
	public StockMaster getStock(String mediName,String comName)
	{
		return stockRepository.getStock(mediName, comName);
	}

}

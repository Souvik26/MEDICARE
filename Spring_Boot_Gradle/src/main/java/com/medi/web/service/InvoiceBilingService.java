package com.medi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.medi.web.constant.GlobalConstant;
import com.medi.web.exception.BusinessException;
import com.medi.web.model.InvoiceMaster;
import com.medi.web.model.StockMaster;
import com.medi.web.repository.InvoiceBilingRepository;
import com.medi.web.repository.StockRepository;

@Service
public class InvoiceBilingService {
	
	@Autowired
	private Environment properties;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private InvoiceBilingRepository invoiceBilingRepository;
	
	public StockMaster getStock(final String mediName) throws BusinessException
	{
		final StockMaster stockMasterInfo;
		try {
			stockMasterInfo=stockRepository.getStockbyMedicineName(mediName);
			return stockMasterInfo;
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_INVALID_MEDICINE_NAME),properties.getProperty(GlobalConstant.ERR_INVALID_STOCK_DETAILS));
		}
	}
	
	public void addInvoiceInList(final InvoiceMaster invoiceMaster)
	{
		invoiceBilingRepository.save(invoiceMaster);
	}

}

package com.medi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.exception.BusinessException;
import com.medi.web.model.ErrorResponse;
import com.medi.web.model.InvoiceMaster;
import com.medi.web.model.StockMaster;
import com.medi.web.service.InvoiceBilingService;
import com.medi.web.view.InvoiceInfoView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/services")
public class InvoiceBilingController {
	
	@Autowired
	private InvoiceBilingService invoiceBilingService;
	
	/**
	 * 
	 * Creating Invoice List in Database
	 * 
	 * @param companyInfoView
	 * @return medicineCompanyMaster
	 * @throws BusinessException
	 */
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@PostMapping(value = "/addInvoiceList", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<String> addInvoiceList(@RequestBody final InvoiceInfoView invoiceInfoView,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		final StockMaster stockMasterInfo=invoiceBilingService.getStock(invoiceInfoView.getMedicineName());
		final InvoiceMaster invoiceMaster;
		if(invoiceInfoView.getQuantity()>stockMasterInfo.getQuantity().getTotalQuantity())
		{
			return ResponseEntity.ok().body(" Unable to sell the product as demanded quantity is greater than what we have ");
		}
		else
		{
			invoiceMaster=new InvoiceMaster();
			invoiceMaster.setQuantity(invoiceInfoView.getQuantity());
			invoiceMaster.setDescription(invoiceInfoView.getDescription());
			invoiceMaster.setBatchId(stockMasterInfo.getBatchId());
			invoiceMaster.setExpiryDate(stockMasterInfo.getExpiryDate());
			invoiceMaster.setCostPerQuantity(stockMasterInfo.getQuantity().getCostPerQuantity());
			invoiceMaster.setCustomerName(invoiceInfoView.getCustomerName());
			invoiceMaster.setCustomerAge(invoiceInfoView.getCustomerAge());
			invoiceBilingService.addInvoiceInList(invoiceMaster);
			return ResponseEntity.ok().body(" Added Successfully ");
		}		
	}

}

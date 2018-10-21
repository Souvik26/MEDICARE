package com.medi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.model.ErrorResponse;
import com.medi.web.model.StockMaster;
import com.medi.web.service.StockService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@GetMapping(value = "/addStock", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<StockMaster> addStock(HttpServletRequest httpServletRequest) throws Exception {
		//throw new Exception("Testing");
		StockMaster stp=new StockMaster();
		stp.setBatchId(124);
		
		stockService.addStock(stp);
		return ResponseEntity.ok().body(stp);
	}
	
	@PostMapping(value = "/getStock", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<StockMaster> getStock(HttpServletRequest httpServletRequest) throws Exception {
		StockMaster stockMaster=new StockMaster();
		
		final StockMaster stockMasterTb=stockService.getStock(stockMaster.getMedicineName(), stockMaster.getCompanyName());
		return ResponseEntity.ok().body(stockMasterTb);
	}

}

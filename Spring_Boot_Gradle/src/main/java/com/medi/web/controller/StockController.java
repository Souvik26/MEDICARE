package com.medi.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.model.ErrorResponse;
import com.medi.web.model.Quantity;
import com.medi.web.model.StockMaster;
import com.medi.web.service.StockService;
import com.medi.web.view.StockInfoView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/services")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@PostMapping(value = "/addStock", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<StockMaster> addStock(@RequestBody final StockInfoView stockInfoView,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		final StockMaster stockMaster=new StockMaster();
		final Quantity quantity=new Quantity();
		BeanUtils.copyProperties(stockInfoView, stockMaster);
		quantity.setAvailableQuantity(stockInfoView.getQuantity().getAvailableQuantity());
		quantity.setCostPerQuantity(stockInfoView.getQuantity().getCostPerQuantity());
		quantity.setTotalQuantity(stockInfoView.getQuantity().getTotalQuantity());
		stockMaster.setQuantity(quantity);
		stockService.addStock(stockMaster);
		return ResponseEntity.ok().body(stockMaster);
	}
	
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@GetMapping(value = "/getStock", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<StockMaster> getStock(@RequestBody final String companyName,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		final StockMaster stockMasterTb=stockService.getStock(companyName);
		return ResponseEntity.ok().body(stockMasterTb);
	}
	
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@GetMapping(value = "/getAllStock", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity <List<StockMaster>> getAllStock(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		final List<StockMaster> stockMasterTbList=stockService.getAllStock();
		return ResponseEntity.ok().body(stockMasterTbList);
	}

}

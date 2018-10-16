package com.medi.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.model.ErrorResponse;
import com.medi.web.model.MedicalCompany;
import com.medi.web.service.CompanyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@GetMapping(value = "/testCompanyinsertion", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<MedicalCompany> testCompanyinsertionRequests(HttpServletRequest httpServletRequest) throws Exception {
		//throw new Exception("Testing");
		MedicalCompany mc=new MedicalCompany();
		mc.setCompany_Name("Sned 56");
		mc.setLedger_Number(256);
		mc.setEntry_Date(new Date());
		companyService.InsertCompany(mc);
		System.err.println("companyService ");
		
		return ResponseEntity.ok().body(mc);
	}

}

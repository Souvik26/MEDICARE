package com.medi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.model.ErrorResponse;
import com.medi.web.model.MedicineCompanyMaster;
import com.medi.web.service.CompanyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 
	 * This is the First Service to Login To the Application.
	 * 
	 * @param httpServletRequest
	 * @return ResponseEntity
	 * @throws Exception This is a Custom Exception
	 */
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@GetMapping(value = "/testCompanyinsertion/abc/{abc}", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<MedicineCompanyMaster> testCompanyinsertionRequests(HttpServletRequest httpServletRequest) throws Exception {
		//throw new Exception("Testing");
		/*MedicineCompanyMaster mc=new MedicineCompanyMaster();
		mc.setCompany_Name("Sned 56");
		mc.setLedger_Number(256);
		mc.setEntry_Date(new Date());
		companyService.InsertCompany(mc);
		System.err.println("companyService ");*/
		MedicineCompanyMaster mc=new MedicineCompanyMaster();
		return ResponseEntity.ok().body(mc);
	}

}

package com.medi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.model.ErrorResponse;
import com.medi.web.model.MedicineCompanyMaster;
import com.medi.web.service.CompanyService;
import com.medi.web.view.CompanyInfoView;

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
	
	@PostMapping(value = "/addCompany", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<MedicineCompanyMaster> addCompany(@RequestBody final CompanyInfoView companyInfoView,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		final MedicineCompanyMaster medicineCompanyMaster=new MedicineCompanyMaster();
		BeanUtils.copyProperties(companyInfoView, medicineCompanyMaster);
		companyService.insertCompany(medicineCompanyMaster);
		return ResponseEntity.ok().body(medicineCompanyMaster);
	}
	
	
	
	/*
	 * This function will take the new model object set the id from the previous
	 * object and then persist the changes. 
	 * 
	 * */

	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	@PostMapping(value = "/getCompany", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<MedicineCompanyMaster> getCompany(@RequestBody final String companyViewName,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		final MedicineCompanyMaster medicineCompanyMaster=companyService.getCompany(companyViewName);
		return ResponseEntity.ok().body(medicineCompanyMaster);
	}
	
	
	/*
	 * This function will take the new model object set the id from the previous
	 * object and then persist the changes. 
	 * 
	 * */
	
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	//this is to be tested without id it is very important
	
	@PostMapping(value = "/saveCompany", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<String> editCompany(@RequestBody final CompanyInfoView companyInfoView,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		
		final MedicineCompanyMaster medicineCompanyMaster=new MedicineCompanyMaster();
		BeanUtils.copyProperties(companyInfoView, medicineCompanyMaster);
		companyService.insertCompany(medicineCompanyMaster);
		return ResponseEntity.ok().body(medicineCompanyMaster.getCompanyName()+" is Saved");
	}
	

}
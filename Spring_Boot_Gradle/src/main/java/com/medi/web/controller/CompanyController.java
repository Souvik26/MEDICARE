package com.medi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })
	
	
	/*
	 * This function will take the new model object set the id from the previous
	 * object and then persist the changes. 
	 * 
	 * */ 
	
	@GetMapping(value = "/addCompany", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<MedicineCompanyMaster> addCompany(HttpServletRequest httpServletRequest) throws Exception {
		MedicineCompanyMaster mc=new MedicineCompanyMaster();
		companyService.insertCompany(mc);
		return ResponseEntity.ok().body(mc);
	}
	
	
	
	/*
	 * This function will take the new model object set the id from the previous
	 * object and then persist the changes. 
	 * 
	 * */
	
	
	@PostMapping(value = "/getCompany", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<MedicineCompanyMaster> getCompany(HttpServletRequest httpServletRequest) throws Exception {
		String st="Sample Company";
		return ResponseEntity.ok().body(companyService.getCompany(st));
	}
	
	
	/*
	 * This function will take the new model object set the id from the previous
	 * object and then persist the changes. 
	 * 
	 * */
	
	
	@PostMapping(value = "/editCompany", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<String> editCompany(HttpServletRequest httpServletRequest) throws Exception {
		MedicineCompanyMaster sampleMedicineCompanyMaster=new MedicineCompanyMaster();
		
		final MedicineCompanyMaster medicineCompanyMaster;
		medicineCompanyMaster=companyService.getCompany(sampleMedicineCompanyMaster.getCompanyName());
		
		sampleMedicineCompanyMaster.setMedicineId(medicineCompanyMaster.getMedicineId());
		companyService.insertCompany(sampleMedicineCompanyMaster);
		return ResponseEntity.ok().body(sampleMedicineCompanyMaster.getCompanyName()+" is Edited");
	}
	

}
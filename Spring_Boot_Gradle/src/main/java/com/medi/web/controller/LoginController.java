package com.medi.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.model.ErrorResponse;
import com.medi.web.model.LoginInfoMaster;
import com.medi.web.service.LoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	@GetMapping(value = "/test", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<LoginInfoMaster> testRequests(HttpServletRequest httpServletRequest) throws Exception {
		//throw new Exception("Testing");
		final LoginInfoMaster loginInfoMaster = new LoginInfoMaster();
		loginInfoMaster.setId(5);
		System.err.println("loginService.AuthenticateLogin "+loginService.AuthenticateLogin("Sned", "12345", "Admin"));
		
		return ResponseEntity.ok().body(loginInfoMaster);
	}
	
	@PostMapping("/test2")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}

}
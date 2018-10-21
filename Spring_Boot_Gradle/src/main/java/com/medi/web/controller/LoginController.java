package com.medi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.web.exception.BusinessException;
import com.medi.web.model.ErrorResponse;
import com.medi.web.model.LoginInfoMaster;
import com.medi.web.service.LoginService;
import com.medi.web.util.JwtTokenUtil;
import com.medi.web.view.LoginInfoView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/services")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * 
	 * Login Credential Validation in Database
	 * 
	 * @param loginInfoMaster
	 * @return LoginInfoMaster
	 * @throws BusinessException
	 */
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	@PostMapping(value = "/login", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<LoginInfoView> doLogin(@RequestBody final LoginInfoView loginInfoView,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		final LoginInfoMaster loginInfoMaster = new LoginInfoMaster();
		BeanUtils.copyProperties(loginInfoView, loginInfoMaster);
		final LoginInfoView authenticatedLoginInfoView = loginService.authenticateLogin(loginInfoMaster);
		httpServletResponse.setHeader("Bearer", jwtTokenUtil.generateWebToken(loginInfoView));
		return ResponseEntity.ok().body(authenticatedLoginInfoView);
	}
	
	/**
	 * 
	 * Register New User
	 * 
	 * @param loginInfoMaster
	 * @throws BusinessException
	 */
	@ApiOperation(nickname = "retrieveRequests", value = "This API is retrieve review requests against a particular reviewer id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = ErrorResponse.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorResponse.class) })

	@PostMapping(value = "/register", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<LoginInfoMaster> registerLoginCredentials(@RequestBody final LoginInfoView loginInfoView,HttpServletRequest httpServletRequest) throws Exception {
		final LoginInfoMaster loginInfoMaster = new LoginInfoMaster();
		BeanUtils.copyProperties(loginInfoView, loginInfoMaster);
		final LoginInfoMaster registeredLoginInfoMaster = loginService.registerLoginCredentials(loginInfoMaster);
		
		return ResponseEntity.ok().body(registeredLoginInfoMaster);
	}

}
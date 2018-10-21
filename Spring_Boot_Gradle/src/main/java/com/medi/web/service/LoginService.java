package com.medi.web.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.medi.web.constant.GlobalConstant;
import com.medi.web.exception.BusinessException;
import com.medi.web.model.LoginInfoMaster;
import com.medi.web.repository.LoginRepository;
import com.medi.web.view.LoginInfoView;

@Service
public class LoginService{

	@Autowired
	private Environment properties;
	@Autowired
	private LoginRepository loginRepository;
	
	/**
	 * 
	 * Login Credential Validation in Database
	 * 
	 * @param loginInfoMaster
	 * @return LoginInfoMaster
	 * @throws BusinessException
	 */
	public LoginInfoView authenticateLogin(final LoginInfoMaster loginInfoMaster) throws BusinessException
	{
		LoginInfoMaster authenticatedLoginInfo= null;
		try {
			authenticatedLoginInfo=loginRepository.authenticateUser(loginInfoMaster);
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_CODE),properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_DETAILS));
		}
		
		if(null!=authenticatedLoginInfo)
		{
			validateUserInfo(loginInfoMaster,authenticatedLoginInfo);
			final LoginInfoView loginInfoView =new LoginInfoView();
			BeanUtils.copyProperties(authenticatedLoginInfo, loginInfoView);
			return loginInfoView;
		}
		else
		{
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_INVALID_USER_CODE),properties.getProperty(GlobalConstant.ERR_INVALID_USER_DETAILS));
		}
	}
	
	/**
	 * 
	 * @param loginInfoMaster
	 * @param authenticateDLoginInfo
	 * @throws BusinessException
	 */
	private void validateUserInfo(final LoginInfoMaster loginInfoMaster,final LoginInfoMaster authenticateDLoginInfo) throws BusinessException{
		if(!loginInfoMaster.getPassword().equals(authenticateDLoginInfo.getPassword())) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_INVALID_USER_CODE),properties.getProperty(GlobalConstant.ERR_INVALID_USER_DETAILS));
		}
	}
	
	/**
	 * 
	 * Register New User
	 * 
	 * @param loginInfoMaster
	 * @throws BusinessException
	 */
	public LoginInfoMaster registerLoginCredentials(final LoginInfoMaster loginInfoMaster) throws BusinessException
	{
		try {
			return loginRepository.save(loginInfoMaster);
		}catch(Exception ex) {
			throw new BusinessException("ERR0001","Error in Database Operation");
		}
	}
}

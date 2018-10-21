package com.medi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.web.model.LoginInfoMaster;
import com.medi.web.model.UserRoleMaster;
import com.medi.web.repository.LoginRepository;

@Service
public class LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	public void registerLogin(LoginInfoMaster loginInfoMaster)
	{
		System.out.println("Inside registerLogin Start");
		loginRepository.save(loginInfoMaster);
	}
	
	public Boolean AuthenticateLogin(String Lname, String Lpassword, String role)
	{
		System.out.println("Inside AuthenticateLogin Start");
		LoginInfoMaster authenticateLoginList=loginRepository.AuthenticateUser(Lname, Lpassword);
		if(null!=authenticateLoginList)
		{
			System.out.println("Inside AuthenticateLogin End Block true");
			return AuthenticateRole(role,(List<UserRoleMaster>) authenticateLoginList.getUserRoleMaster());
		}
		else
		{
			System.out.println("Inside AuthenticateLogin End Block false");
			return false;
		}
	}
	
	private Boolean AuthenticateRole(String role,List<UserRoleMaster> roleList)
	{
		System.out.println("Inside AuthenticateRole Start");
		if(null!=roleList && roleList.size()>0 && roleList.contains(role))
		{
			System.out.println("Inside AuthenticateRole End Block true");
			return true;
		}
		else
		{
			System.out.println("Inside AuthenticateRole End Block false");
			return false;
		}
	}
}

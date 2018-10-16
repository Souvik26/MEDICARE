package com.medi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.web.model.LoginModal;
import com.medi.web.model.UserRoleModal;
import com.medi.web.repository.LoginRepository;

@Service
public class LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	public void registerLogin(LoginModal loginModal)
	{
		System.out.println("Inside registerLogin Start");
		loginRepository.save(loginModal);
	}
	
	public Boolean AuthenticateLogin(String Lname, String Lpassword, String role)
	{
		System.out.println("Inside AuthenticateLogin Start");
		List<LoginModal> authenticateLoginList=loginRepository.AuthenticateUser(Lname, Lpassword);
		if(null!=authenticateLoginList && !authenticateLoginList.isEmpty() && authenticateLoginList.size()>0)
		{
			System.out.println("Inside AuthenticateLogin End Block true");
			return AuthenticateRole(role,(List<UserRoleModal>) authenticateLoginList.get(0).getUserRoleModal());
		}
		else
		{
			System.out.println("Inside AuthenticateLogin End Block false");
			return false;
		}
	}
	
	private Boolean AuthenticateRole(String role,List<UserRoleModal> roleList)
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

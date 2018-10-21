package com.medi.web.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="LOGIN_MST")
public class LoginInfoMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="loginInfoMaster",cascade=CascadeType.ALL)
	private Collection<UserRoleMaster> userRoleMaster=new ArrayList<UserRoleMaster>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<UserRoleMaster> getUserRoleMaster() {
		return userRoleMaster;
	}

	public void setUserRoleMaster(Collection<UserRoleMaster> userRoleMaster) {
		this.userRoleMaster = userRoleMaster;
	}
	
}
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

@Entity
public class LoginModal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Login_id")
	private int Id;
	@Column(name = "Login_name")
	private String Username;
	@Column(name = "Login_password")
	private String Password;
	
	@OneToMany(mappedBy="loginModal",cascade=CascadeType.ALL)
	private Collection<UserRoleModal> userRoleModal=new ArrayList<UserRoleModal>();
	
	
	public Collection<UserRoleModal> getUserRoleModal() {
		return userRoleModal;
	}
	public void setUserRoleModal(Collection<UserRoleModal> userRoleModal) {
		this.userRoleModal = userRoleModal;
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

}
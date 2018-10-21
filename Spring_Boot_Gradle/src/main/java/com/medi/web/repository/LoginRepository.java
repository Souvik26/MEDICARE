package com.medi.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medi.web.model.LoginInfoMaster;

@Repository
public interface LoginRepository extends JpaRepository<LoginInfoMaster, Integer>{
	@Query("SELECT lm FROM LOGIN_MST lm ")
	List<LoginInfoMaster> AuthenticateUser(@Param("Lname") String Login_name, @Param("Lpassword") String Login_password);
}

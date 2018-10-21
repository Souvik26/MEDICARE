package com.medi.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medi.web.model.LoginModal;

@Repository
public interface LoginRepository extends JpaRepository<LoginModal, Integer>{
	@Query("SELECT lm FROM LoginModal lm  WHERE lm.Username=(:Lname) AND lm.Password= (:Lpassword)")
	List<LoginModal> AuthenticateUser(@Param("Lname") String Login_name, @Param("Lpassword") String Login_password);
}

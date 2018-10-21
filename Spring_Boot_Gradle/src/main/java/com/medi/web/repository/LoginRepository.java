package com.medi.web.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medi.web.model.LoginInfoMaster;

@Repository
public interface LoginRepository extends JpaRepository<LoginInfoMaster, Integer>{
	
	@Query("SELECT lm FROM LOGIN_MST lm WHERE LOWER(lm.email)=LOWER(:#{#loginInfo.email})")
	LoginInfoMaster authenticateUser(@Param("loginInfo") final LoginInfoMaster loginInfoMaster) throws DataAccessException;
}

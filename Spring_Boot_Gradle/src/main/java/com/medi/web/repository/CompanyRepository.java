package com.medi.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.medi.web.model.MedicalCompany;

@Transactional
public interface CompanyRepository extends JpaRepository<MedicalCompany, Integer>{
	
	@Query("SELECT lm FROM MedicalCompany lm  WHERE lm.Company_Name=(:cname)")
	List<MedicalCompany> CompanySelected(@Param("cname") String companyName);
}

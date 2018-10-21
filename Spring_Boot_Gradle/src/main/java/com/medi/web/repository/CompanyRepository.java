package com.medi.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.medi.web.model.MedicineCompanyMaster;

@Transactional
public interface CompanyRepository extends JpaRepository<MedicineCompanyMaster, Integer>{
	
	@Query("SELECT lm FROM MEDICINE_COMPANY_MST lm")
	List<MedicineCompanyMaster> CompanySelected(@Param("cname") String companyName);
}

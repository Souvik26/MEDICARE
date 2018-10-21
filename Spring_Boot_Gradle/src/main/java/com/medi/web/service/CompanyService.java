package com.medi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.web.model.MedicineCompanyMaster;
import com.medi.web.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public void insertCompany(final MedicineCompanyMaster medicineCompanyMaster)
	{
		companyRepository.save(medicineCompanyMaster);
	}
	
	public MedicineCompanyMaster getCompany(final String companyName)
	{
		return companyRepository.companySelected(companyName);
	}
	
}

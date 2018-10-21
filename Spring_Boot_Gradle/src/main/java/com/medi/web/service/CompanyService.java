package com.medi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.web.model.MedicalCompany;
import com.medi.web.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public void InsertCompany(MedicalCompany medicalCompany)
	{
		companyRepository.save(medicalCompany);
	}
	
	public MedicalCompany updateCompany(String companyName,MedicalCompany medicalCompany)
	{
		MedicalCompany medicalCompanyTemp=new MedicalCompany();
		medicalCompanyTemp=(MedicalCompany)companyRepository.CompanySelected(companyName);
		companyRepository.save(medicalCompany);
		return medicalCompanyTemp;
	}

}

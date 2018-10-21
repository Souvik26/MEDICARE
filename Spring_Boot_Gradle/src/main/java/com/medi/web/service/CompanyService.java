package com.medi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.web.model.MedicineCompanyMaster;
import com.medi.web.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public void InsertCompany(final MedicineCompanyMaster medicineCompanyMaster)
	{
		companyRepository.save(medicineCompanyMaster);
	}
	
	/*public MedicalCompany updateCompany(final String companyName,final MedicineCompanyMaster medicineCompanyMaster)
	{
		MedicalCompany medicalCompanyTemp=new MedicalCompany();
		medicalCompanyTemp=(MedicalCompany)companyRepository.CompanySelected(companyName);
		companyRepository.save(medicalCompany);
		return medicalCompanyTemp;
	}*/

}

package com.medi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.medi.web.constant.GlobalConstant;
import com.medi.web.exception.BusinessException;
import com.medi.web.model.MedicineCompanyMaster;
import com.medi.web.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private Environment properties;
	@Autowired
	private CompanyRepository companyRepository;
	
	public void insertCompany(final MedicineCompanyMaster medicineCompanyMaster) throws BusinessException
	{
		try {
			companyRepository.save(medicineCompanyMaster);
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_CODE),properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_DETAILS));
		}
	}
	
	public MedicineCompanyMaster getCompany(final String companyName) throws BusinessException
	{
		MedicineCompanyMaster getCompanyInfo=null;
		try {
			getCompanyInfo=companyRepository.companySelected(companyName);
			return getCompanyInfo;
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_CODE),properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_DETAILS));
		}
	}
	
	public List<MedicineCompanyMaster> getAllCompanies() throws BusinessException
	{
		List<MedicineCompanyMaster> getCompanyInfoList=null;
		try {
			getCompanyInfoList=companyRepository.findAll();
			return getCompanyInfoList;
		}catch(Exception ex) {
			throw new BusinessException(properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_CODE),properties.getProperty(GlobalConstant.ERR_DATABASE_OPERATION_DETAILS));
		}
	}
	
}

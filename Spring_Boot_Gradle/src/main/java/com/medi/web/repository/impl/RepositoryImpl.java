package com.medi.web.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medi.web.model.LoginModal;
import com.medi.web.model.MedicalCompany;
import com.medi.web.repository.CompanyRepository;
import com.medi.web.repository.LoginRepository;

@Repository
@Transactional(readOnly = true)
public class RepositoryImpl {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	public void saveCompany(MedicalCompany medicalCompany)
	{
		companyRepository.save(medicalCompany);
	}
	
	public void saveLogin(LoginModal loginModal)
	{
		loginRepository.save(loginModal);
	}
	
	public Boolean authentifiedLogin()
	{
		TypedQuery<LoginModal> query = em.createQuery("select a from LoginModal a where a.Username = ?", LoginModal.class);
		query.setParameter(1, "SNED");
		List<LoginModal> lst=query.getResultList();
		if(null!=lst && lst.size()>0)
		{
			System.out.println("Data is not empty");
			return true;
		}
		else
		{
			return false;
		}
	}

}

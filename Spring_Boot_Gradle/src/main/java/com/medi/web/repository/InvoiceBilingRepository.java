package com.medi.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medi.web.model.InvoiceMaster;


@Repository
public interface InvoiceBilingRepository extends JpaRepository<InvoiceMaster, Integer>{

}

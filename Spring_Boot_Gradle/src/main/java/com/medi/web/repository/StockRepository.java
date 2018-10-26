package com.medi.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medi.web.model.StockMaster;


@Repository
public interface StockRepository extends JpaRepository<StockMaster, Integer>{
	@Query("SELECT lm FROM STOCK_MST_TB lm where companyName=(:cName)")
	StockMaster getStockByCompanyName(@Param("cName") String comName);
	
	@Query("SELECT lm FROM STOCK_MST_TB lm where medicineName=(:mName)")
	StockMaster getStockbyMedicineName(@Param("mName") String mediName);
}

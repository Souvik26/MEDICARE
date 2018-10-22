package com.medi.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medi.web.model.StockMaster;


@Repository
public interface StockRepository extends JpaRepository<StockMaster, Integer>{
	@Query("SELECT lm FROM STOCK_MST_TB lm where medicineName=(:mName) and companyName=(:cName)")
	StockMaster getStock(@Param("mName") String mediName, @Param("cName") String comName);
}

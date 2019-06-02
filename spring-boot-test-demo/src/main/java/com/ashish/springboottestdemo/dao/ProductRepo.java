package com.ashish.springboottestdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.springboottestdemo.bean.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByIsActiveTrue();

	/*
	@Modifying
	@Query("update Product p set p.productAdmin.productAdminId = :productAdminId where p.productId = :productId")
	int updateProduct(@Param("productId") Integer productId, @Param("productAdminId") Integer productAdminId);
			*/
}

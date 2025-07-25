package com.productManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productManagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

package com.tcs.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.productapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
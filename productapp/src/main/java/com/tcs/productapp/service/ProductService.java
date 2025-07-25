package com.tcs.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.productapp.entity.Product;
import com.tcs.productapp.repository.ProductRepository;

import java.util.*;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}

@Service
class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repo.findById(id).get(); // no exception handling yet
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = repo.findById(id).get();
        existing.setPname(product.getPname());
        existing.setPrice(product.getPrice());
        existing.setReview(product.getReview());
        return repo.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
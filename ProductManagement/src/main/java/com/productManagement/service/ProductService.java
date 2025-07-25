package com.productManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productManagement.entity.Product;
import com.productManagement.exception.NotFoundException;
import com.productManagement.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product with ID " + id + " not found"));
	}

	public String updateProduct(long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}
    
	
	/*public String deleteProduct(long id) {
	    Product existingProduct = productRepository.findById(id)
	        .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
	    
	    productRepository.deleteById(id);
	    return "Product with id " + id + " has been deleted successfully.";
	}*/
	public String deleteProduct(long id) {
		Product existingProduct = productRepository.findById(id).get();
		if(existingProduct==null) {
			return "Product not found with id: " + id;
		}
		else {
			productRepository.deleteById(id);
		}
		return "Product deleted succssfully";
		
	}

}

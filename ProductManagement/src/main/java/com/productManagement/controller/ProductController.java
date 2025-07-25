package com.productManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productManagement.entity.Product;
import com.productManagement.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public void addNewProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("{id}")
	public String updateProductDetails(@PathVariable long id, @RequestBody Product product) {
		return productService.updateProduct(id,product);
	}
	
	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable long id) {
	    return productService.deleteProduct(id);
	}

	
//	@GetMapping("/csrf")
//	public CsrfToken getToken(HttpServletRequest request) {
//          return  (CsrfToken) request.getAttribute("_csrf"); 
//	}
}

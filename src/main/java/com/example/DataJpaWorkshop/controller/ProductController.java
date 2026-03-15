package com.example.DataJpaWorkshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataJpaWorkshop.Projections.ProductView;
import com.example.DataJpaWorkshop.entity.*;
import com.example.DataJpaWorkshop.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
	
	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
	@Autowired
	private ProductService service;
	@GetMapping("/products/page/{page}/size/{size}")
	public List<Product> getByPagination(@PathVariable int page, @PathVariable int size) {
		return service.getProductsWithPagination(page, size);
	}
	
	@GetMapping("/products/projection/{price}")
	public List<ProductView> getProducts(@PathVariable double price) {
	    return service.getProductsWithProjection(price);
	}
}

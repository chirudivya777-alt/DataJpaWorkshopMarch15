package com.example.DataJpaWorkshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.DataJpaWorkshop.repository.ProductRepository;
import com.example.DataJpaWorkshop.DTO.ProductDTO;
import com.example.DataJpaWorkshop.Projections.ProductView;
import com.example.DataJpaWorkshop.entity.*;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	 public List<Product> getAllProducts() {
	        return repo.findAll();
	    }
	public List<Product> getProductsWithPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
		return repo.findAll(pageable).getContent();
	}		
		
	public List<ProductView> getProductsWithProjection(double price) {
		return repo.findByPriceGreaterThan(price);
	}
	
	public List<ProductDTO>getProductWithName(String name){
		return repo.findByNameContaining(name);
		
	}

	    public Product saveProduct(Product product) {
	        return repo.save(product);
	    }

	}



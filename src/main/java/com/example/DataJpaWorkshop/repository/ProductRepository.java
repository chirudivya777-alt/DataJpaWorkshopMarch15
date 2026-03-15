package com.example.DataJpaWorkshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DataJpaWorkshop.DTO.ProductDTO;
import com.example.DataJpaWorkshop.Projections.ProductView;
import com.example.DataJpaWorkshop.entity.*;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<ProductView> findByPriceGreaterThan(double price);
	List<ProductDTO> findByNameContaining(String name);
	

}

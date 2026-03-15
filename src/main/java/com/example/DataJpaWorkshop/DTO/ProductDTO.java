package com.example.DataJpaWorkshop.DTO;

public class ProductDTO {
	String name;
	Double price;
	
	
	public ProductDTO(String name, double price) {
		this.name = name;
		this.price = price;

}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	
	
	
}

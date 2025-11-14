package com.yg.microservices.product.service;

import org.springframework.stereotype.Service;

import com.yg.microservices.product.dto.ProductRequest;
import com.yg.microservices.product.model.Product;
import com.yg.microservices.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		
		Product product = Product.builder()
				.name(productRequest.name())
				.description(productRequest.description())
				.price(productRequest.price())
				.build();
		
		productRepository.save(product);
		
		
	}
	


}

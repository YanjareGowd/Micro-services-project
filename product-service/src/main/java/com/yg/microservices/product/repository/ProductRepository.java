package com.yg.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yg.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}

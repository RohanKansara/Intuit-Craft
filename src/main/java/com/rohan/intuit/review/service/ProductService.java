package com.rohan.intuit.review.service;

import com.rohan.intuit.review.entity.Product;
import com.rohan.intuit.review.repository.ProductRepository;
import com.rohan.intuit.review.repository.db.DBProductRepositoryService;
import com.rohan.intuit.review.request.ProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    DBProductRepositoryService productRepository;

    public Product createProduct(ProductCatalog productCatalog) {
        return productRepository.saveProduct(productCatalog);
    }
}

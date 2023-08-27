package com.rohan.intuit.review.resource;

import com.rohan.intuit.review.entity.Product;
import com.rohan.intuit.review.request.ProductCatalog;
import com.rohan.intuit.review.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping("product")
    public Product createProduct(@RequestBody ProductCatalog productCatalog) {
        log.info("Received request to create product with name {} and sellerId {}",
                productCatalog.getName(), productCatalog.getSellerId());
        return productService.createProduct(productCatalog);
    }
}

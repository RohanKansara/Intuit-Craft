package com.rohan.intuit.review.repository.db;

import com.rohan.intuit.review.entity.Buyer;
import com.rohan.intuit.review.entity.Product;
import com.rohan.intuit.review.entity.Seller;
import com.rohan.intuit.review.exception.ProductException;
import com.rohan.intuit.review.repository.BuyerRepository;
import com.rohan.intuit.review.repository.ProductRepository;
import com.rohan.intuit.review.request.ProductCatalog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class DBProductRepositoryService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DBSellerRepositoryService sellerRepositoryService;


    public Product findProduct(Long buyerId) {
        Optional<Product> product = productRepository.findById(buyerId);

        return product.orElseThrow(() -> new ProductException("Invalid Product, Product Dosent Exist"));
    }

    public Product saveProduct(ProductCatalog productCatalog) {
        Seller seller = sellerRepositoryService.findSeller(productCatalog.getSellerId());

        log.info("Seller exists with sellerId {} and name {}", productCatalog.getSellerId(), seller.getName());

        Product product = Product.builder()
                .price(productCatalog.getPrice())
                .name(productCatalog.getName())
                .productCategory(productCatalog.getProductCategory())
                .seller(seller)
                .specifications(productCatalog.getSpecifications())
                .build();

        return productRepository.save(product);
    }
}

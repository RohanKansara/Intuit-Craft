package com.rohan.intuit.review.repository;

import com.rohan.intuit.review.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

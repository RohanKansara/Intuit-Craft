package com.rohan.intuit.review.repository;

import com.rohan.intuit.review.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}

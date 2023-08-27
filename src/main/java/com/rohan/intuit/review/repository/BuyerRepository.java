package com.rohan.intuit.review.repository;

import com.rohan.intuit.review.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}

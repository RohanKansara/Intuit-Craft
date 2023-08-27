package com.rohan.intuit.review.repository.db;

import com.rohan.intuit.review.entity.Buyer;
import com.rohan.intuit.review.exception.BuyerException;
import com.rohan.intuit.review.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DBBuyerRepositoryService {

    @Autowired
    BuyerRepository buyerRepository;

    public Buyer findBuyer(Long buyerId) {
        Optional<Buyer> buyer = buyerRepository.findById(buyerId);

        return buyer.orElseThrow(()-> new BuyerException("Invalid Buyer, Buyer Dosent Exist"));
    }
}

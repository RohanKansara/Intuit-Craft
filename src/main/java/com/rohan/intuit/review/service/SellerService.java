package com.rohan.intuit.review.service;

import com.rohan.intuit.review.entity.Seller;
import com.rohan.intuit.review.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}

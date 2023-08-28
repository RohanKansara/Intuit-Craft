package com.rohan.intuit.review.repository.db;

import com.rohan.intuit.review.entity.Buyer;
import com.rohan.intuit.review.entity.Seller;
import com.rohan.intuit.review.exception.BuyerException;
import com.rohan.intuit.review.exception.SellerException;
import com.rohan.intuit.review.repository.BuyerRepository;
import com.rohan.intuit.review.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class DBSellerRepositoryService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller findSeller(Long sellerId) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);

        log.info("Seller with sellerId {} is {}", sellerId, seller);

        return seller.orElseThrow(()-> new SellerException("Invalid Seller, Seller Dosent Exist"));
    }

    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}

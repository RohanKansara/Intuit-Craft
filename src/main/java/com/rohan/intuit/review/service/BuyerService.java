package com.rohan.intuit.review.service;

import com.rohan.intuit.review.entity.Buyer;
import com.rohan.intuit.review.repository.BuyerRepository;
import com.rohan.intuit.review.repository.db.DBBuyerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    DBBuyerRepositoryService dbBuyerRepositoryService;

    public Buyer createrBuyer(Buyer buyer) {
        return dbBuyerRepositoryService.addBuyer(buyer);
    }
}

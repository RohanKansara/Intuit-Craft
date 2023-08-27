package com.rohan.intuit.review.resource;

import com.rohan.intuit.review.entity.Seller;
import com.rohan.intuit.review.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class SellerResource {

    @Autowired
    SellerService sellerService;

    @PostMapping("seller")
    public Seller createSeller(@RequestBody Seller seller) {
        log.info("Received request to create seller with name {}", seller.getName());
        return sellerService.createSeller(seller);
    }
}

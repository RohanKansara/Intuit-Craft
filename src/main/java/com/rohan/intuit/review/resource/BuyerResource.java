package com.rohan.intuit.review.resource;

import com.rohan.intuit.review.entity.Buyer;
import com.rohan.intuit.review.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class BuyerResource {

    @Autowired
    BuyerService buyerService;

    @PostMapping("buyer")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        log.info("Received request to create buyer with name {}", buyer.getName());
        return buyerService.createrBuyer(buyer);
    }
}

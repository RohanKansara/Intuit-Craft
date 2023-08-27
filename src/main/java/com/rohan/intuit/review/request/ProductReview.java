package com.rohan.intuit.review.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductReview {

    int rating;

    String comment;

    Long buyerId;

    Long productId;
}

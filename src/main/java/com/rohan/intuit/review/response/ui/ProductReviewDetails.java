package com.rohan.intuit.review.response.ui;

import com.rohan.intuit.review.response.repository.ProductReviews;
import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class ProductReviewDetails {

    double rating;

    Map<Integer, Long> ratingCount;

    List<ProductReviews> productReviews;
}

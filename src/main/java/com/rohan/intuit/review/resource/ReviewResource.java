package com.rohan.intuit.review.resource;

import com.rohan.intuit.review.entity.Review;
import com.rohan.intuit.review.request.ProductReview;
import com.rohan.intuit.review.response.ui.ProductReviewDetails;
import com.rohan.intuit.review.service.ReviewService;
import com.rohan.intuit.review.utils.AggregationMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ReviewResource {

    @Autowired
    ReviewService reviewService;

    @PostMapping("review")
    public Review addReview(@RequestBody ProductReview productReview) {
        return reviewService.addReview(productReview);
    }

    @GetMapping("review/{productId}")
    public ProductReviewDetails getProductReview(@RequestParam(defaultValue = "0") Integer pageNo,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @RequestParam(defaultValue = "id") String sortBy,
                                                 @RequestParam(defaultValue = "AVERAGE")
                                                     AggregationMethod aggregationMethod,
                                                 @PathVariable("productId") Long productId) {
        return reviewService.getProductReview(productId, pageNo, pageSize, sortBy, aggregationMethod);
    }

    @PutMapping("review/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") Long reviewId, @RequestBody ProductReview productReview) {
        return reviewService.updateReview(reviewId, productReview);
    }

    @GetMapping("review/like/{reviewId}")
    public Review likeReview(@PathVariable("reviewId") Long reviewId) {
        return reviewService.likeReview(reviewId);
    }

    @GetMapping("review/dislike/{reviewId}")
    public Review disLikeReview(@PathVariable("reviewId") Long reviewId) {
        return reviewService.dislikeReview(reviewId);
    }
}

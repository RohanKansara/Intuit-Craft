package com.rohan.intuit.review.service;

import com.rohan.intuit.review.aggregator.RatingCountService;
import com.rohan.intuit.review.entity.Review;
import com.rohan.intuit.review.exception.ProductException;
import com.rohan.intuit.review.factory.AggregatedScoreFactory;
import com.rohan.intuit.review.repository.db.DBReviewRepositoryService;
import com.rohan.intuit.review.request.ProductReview;
import com.rohan.intuit.review.response.repository.ProductReviews;
import com.rohan.intuit.review.response.ui.ProductReviewDetails;
import com.rohan.intuit.review.utils.AggregationMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    DBReviewRepositoryService dbReviewRepositoryService;

    @Autowired
    RatingCountService ratingCountService;

    public Review likeReview(Long reviewId) {
        return dbReviewRepositoryService.likeReview(reviewId);
    }

    public Review addReview(ProductReview productReview) {

        return dbReviewRepositoryService.saveReview(productReview);
    }

    public ProductReviewDetails getProductReview(Long productId, int pageNo, int pageSize, String sortBy,
                                                 AggregationMethod aggregationMethod) {

        List<ProductReviews> productReviews = dbReviewRepositoryService.getProductReviews(productId, pageNo, pageSize, sortBy);

        double rating = AggregatedScoreFactory.getAggregatedScore(aggregationMethod).getAggregatedScoreOfReview(productId);

        Map<Integer, Long> ratingCount = ratingCountService.reviewCount(productId);

        return ProductReviewDetails
                .builder()
                .rating(rating)
                .ratingCount(ratingCount)
                .productReviews(productReviews)
                .build();
    }

    public Review dislikeReview(Long reviewId) {
        return dbReviewRepositoryService.disLikeReview(reviewId);
    }

    public Review updateReview(Long reviewId, ProductReview productReview) {
        return dbReviewRepositoryService.updateReview(reviewId, productReview);
    }
}

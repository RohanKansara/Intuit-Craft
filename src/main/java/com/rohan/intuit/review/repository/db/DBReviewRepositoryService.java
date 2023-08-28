package com.rohan.intuit.review.repository.db;

import com.rohan.intuit.review.entity.Review;
import com.rohan.intuit.review.exception.ReviewException;
import com.rohan.intuit.review.repository.ReviewRepository;
import com.rohan.intuit.review.request.ProductReview;
import com.rohan.intuit.review.response.repository.ProductReviews;
import com.rohan.intuit.review.response.repository.RatingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DBReviewRepositoryService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    DBBuyerRepositoryService dbBuyerRepositoryService;

    @Autowired
    DBProductRepositoryService dbProductRepositoryService;

    @Cacheable(value = "productReviews", key = "#productId")
    public List<ProductReviews> getProductReviews(Long productId, int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return reviewRepository.getProductReviews(productId, paging);
    }

    public Review saveReview(ProductReview productReview) {
        Review review = Review.builder()
                .rating(productReview.getRating())
                .comment(productReview.getComment())
                .buyer(dbBuyerRepositoryService.findBuyer(productReview.getBuyerId()))
                .product(dbProductRepositoryService.findProduct(productReview.getProductId()))
                .build();

        checkIfReviewAlreadyExists(productReview.getBuyerId(), productReview.getProductId());

        return reviewRepository.save(review);
    }

    public void checkIfReviewAlreadyExists(Long buyerId, Long productId) {
        Review review = reviewRepository.findByBuyerIdAndProductId(buyerId, productId);

        if(review!=null) {
            throw new ReviewException("Review is already submitted for the product, please try updating it!");
        }
    }

    @Cacheable(value = "productRatings", key = "#productId")
    public List<Integer> findRatingsByProductId(Long productId) {
        return reviewRepository.findRatingsByProductId(productId);
    }

    @Cacheable(value = "productRatingsForWA", key = "#productId")
    public List<RatingDetails> findRatingsDataByProductId(Long productId) {
        return reviewRepository.findRatingDataByProductId(productId);
    }

        public Review likeReview(Long reviewId) {
        Review review = findReview(reviewId);

        review.setLikeCount(review.getLikeCount() + 1);

        return reviewRepository.save(review);

    }

    public Review disLikeReview(Long reviewId) {
        Review review = findReview(reviewId);

        review.setDislikeCount(review.getDislikeCount() + 1);

        return reviewRepository.save(review);
    }

    @Cacheable(value = "review", key = "#reviewId")
    public Review findReview(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);

        return review.orElseThrow(() -> new ReviewException("Invalid Review, Review Dosent Exist"));
    }

    public Review updateReview(Long reviewId, ProductReview productReview) {
        Review review = findReview(reviewId);
        review.setRating(productReview.getRating());
        review.setComment(productReview.getComment());

        return reviewRepository.save(review);
    }
}

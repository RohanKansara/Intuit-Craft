package com.rohan.intuit.review.repository;

import com.rohan.intuit.review.entity.Review;
import com.rohan.intuit.review.response.repository.ProductReviews;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select r.id as reviewId, s.name as sellerName, p.name as productName, r.rating, r.comment, b.name as buyerName, " +
            "r.like_count as likeCount, r.dislike_count as disLikeCount, r.time_stamp as timeStamp" +
            " FROM Review r inner join Product p on r.product_id = p.id " +
            "and p.id=?1 inner join Buyer b on r.buyer_id=b.id inner join seller s on p.seller_id=s.id", nativeQuery = true)
    List<ProductReviews> getProductReviews(Long productId, Pageable pageable);

    @Query(value = "select rating from Review where product_id=?1")
    List<Integer> findRatingsByProductId(Long productId);

    Review findByBuyerIdAndProductId(Long buyerId, Long productId);
}

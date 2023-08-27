package com.rohan.intuit.review.response.repository;


import java.util.Date;

public interface ProductReviews {
    Long getReviewId();

    String getSellerName();

    String productName();

    Integer getRating();

    String getComment();

    String getBuyerName();

    Integer getLikeCount();

    Integer getDisLikeCount();

    Date getTimeStamp();
}

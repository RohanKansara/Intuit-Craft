package com.rohan.intuit.review.aggregator;

import com.rohan.intuit.review.repository.ReviewRepository;
import com.rohan.intuit.review.repository.db.DBReviewRepositoryService;
import com.rohan.intuit.review.utils.AggregationMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Component
public class AverageAggregatedScore implements AggregatedScore{

    @Autowired
    DBReviewRepositoryService reviewRepository;

    @Override
    public double getAggregatedScoreOfReview(Long productId) {
        List<Integer> ratings = reviewRepository.findRatingsByProductId(productId);

        double rating =  ratings.stream().mapToInt(val -> val).average().orElse(0.0);

        BigDecimal bd = BigDecimal.valueOf(rating).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public AggregationMethod getMethod() {
        return AggregationMethod.AVERAGE;
    }
}

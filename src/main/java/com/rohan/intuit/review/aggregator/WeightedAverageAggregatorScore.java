package com.rohan.intuit.review.aggregator;

import com.rohan.intuit.review.repository.db.DBReviewRepositoryService;
import com.rohan.intuit.review.response.repository.RatingDetails;
import com.rohan.intuit.review.utils.AggregationMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component()
public class WeightedAverageAggregatorScore implements AggregatedScore {

    @Autowired
    DBReviewRepositoryService dbReviewRepositoryService;

    @Override
    public double getAggregatedScoreOfReview(Long productId) {
        List<RatingDetails> ratingDetails = dbReviewRepositoryService.findRatingsDataByProductId(productId);

        double weightedSum = getWeightedSum(ratingDetails);
        int totalWeights = getTotalWeight(ratingDetails);

        double aggregatedRating = weightedSum /totalWeights;

        BigDecimal bd = BigDecimal.valueOf(aggregatedRating).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();

    }

    private double getWeightedSum(List<RatingDetails> ratingDetails) {
        return ratingDetails.stream()
                .mapToDouble(review -> review.getRating() * getWeightBasedOnCertifiedBuyer(review.getCertifiedBuyer()))
                .sum();
    }

    private int getTotalWeight(List<RatingDetails> ratingDetails) {
        return ratingDetails.stream()
                .mapToInt(review -> getWeightBasedOnCertifiedBuyer(review.getCertifiedBuyer()))
                .sum();
    }

    private int getWeightBasedOnCertifiedBuyer(boolean isCertifiedBuyer) {
        return isCertifiedBuyer ? 10 : 2;
    }

    @Override
    public AggregationMethod getMethod() {
        return AggregationMethod.WEIGHTED_AVERAGE;
    }
}

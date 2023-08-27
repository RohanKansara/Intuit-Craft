package com.rohan.intuit.review.aggregator;

import com.rohan.intuit.review.utils.AggregationMethod;
import org.springframework.stereotype.Component;

@Component()
public class WeightedAverageAggregatorScore implements AggregatedScore{
    @Override
    public double getAggregatedScoreOfReview(Long productId) {
        return 0;
    }

    @Override
    public AggregationMethod getMethod() {
        return AggregationMethod.WEIGHTED_AVERAGE;
    }
}

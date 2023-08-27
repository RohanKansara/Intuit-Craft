package com.rohan.intuit.review.aggregator;

import com.rohan.intuit.review.utils.AggregationMethod;

public interface AggregatedScore {

    double getAggregatedScoreOfReview(Long productId);

    AggregationMethod getMethod();
}

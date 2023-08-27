package com.rohan.intuit.review.factory;

import com.rohan.intuit.review.aggregator.AggregatedScore;
import com.rohan.intuit.review.utils.AggregationMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AggregatedScoreFactory {

    @Autowired
    private List<AggregatedScore> aggregatedScore;

    private static final Map<AggregationMethod, AggregatedScore> aggregatedScoreMap = new HashMap<>();

    @PostConstruct
    public void initAggregatedScoreMapping() {
        for(AggregatedScore service : aggregatedScore) {
            aggregatedScoreMap.put(service.getMethod(), service);
        }
    }

    public static AggregatedScore getAggregatedScore(AggregationMethod method) {
        return aggregatedScoreMap.get(method);
    }
}

package com.rohan.intuit.review.aggregator;

import com.rohan.intuit.review.repository.ReviewRepository;
import com.rohan.intuit.review.repository.db.DBReviewRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
public class RatingCountService {

    @Autowired
    DBReviewRepositoryService reviewRepository;

    public Map<Integer, Long> reviewCount(Long productId) {
        List<Integer> ratings = reviewRepository.findRatingsByProductId(productId);
        return ratings.stream()
                .collect(groupingBy(p -> p, counting()));
    }
}

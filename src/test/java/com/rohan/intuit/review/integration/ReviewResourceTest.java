package com.rohan.intuit.review.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohan.intuit.review.entity.Review;
import com.rohan.intuit.review.repository.db.DBReviewRepositoryService;
import com.rohan.intuit.review.request.ProductReview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReviewResourceTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    DBReviewRepositoryService dbReviewRepositoryService;

    @Test
    void should_create_new_review_for_existing_product() throws Exception {
        ProductReview productReview = ProductReview.builder()
                .productId(1L)
                .buyerId(1L)
                .comment("About Product")
                .rating(4)
                .build();
        ResultActions response = mockMvc.perform(post("/api/v1/review")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productReview)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.rating", is(productReview.getRating())))
                .andExpect(jsonPath("$.likeCount", is(0)))
                .andExpect(jsonPath("$.dislikeCount", is(0)))
                .andExpect(jsonPath("$.comment", is(productReview.getComment())));
    }

    @Test
    void should_throw_exception_on_saving_review_for_invalid_buyer() throws Exception {
        ProductReview productReview = ProductReview.builder()
                .productId(1L)
                .buyerId(1000L)
                .comment("About Product")
                .rating(4)
                .build();
        ResultActions response = mockMvc.perform(post("/api/v1/review")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productReview)));

        response.andExpect(status().is4xxClientError())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Invalid Buyer, Buyer Dosent Exist")));

    }

    @Test
    void should_throw_exception_on_saving_review_for_invalid_product() throws Exception {
        ProductReview productReview = ProductReview.builder()
                .productId(1000L)
                .buyerId(1L)
                .comment("About Product")
                .rating(4)
                .build();
        ResultActions response = mockMvc.perform(post("/api/v1/review")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productReview)));

        response.andExpect(status().is4xxClientError())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Invalid Product, Product Dosent Exist")));

    }

    @Test
    void should_throw_exception_on_saving_review_for_already_existing_product_buyer_review() throws Exception {
        ProductReview productReview = ProductReview.builder()
                .productId(2L)
                .buyerId(2L)
                .comment("About Product")
                .rating(4)
                .build();
        ResultActions response = mockMvc.perform(post("/api/v1/review")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productReview)));

        response.andExpect(status().is4xxClientError())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Review is already submitted for the product, please try updating it!")));

    }

    @Test
    void should_like_existing_review() throws Exception {
        Review review = dbReviewRepositoryService.findReview(3L);

        ResultActions response = mockMvc.perform(get("/api/v1/review/like/3"));


        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.likeCount", is(review.getLikeCount()+1)))
                .andExpect(jsonPath("$.dislikeCount", is(review.getDislikeCount())));
    }

    @Test
    void should_dislike_existing_review() throws Exception {
        Review review = dbReviewRepositoryService.findReview(2L);

        ResultActions response = mockMvc.perform(get("/api/v1/review/dislike/2"));


        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.likeCount", is(review.getLikeCount())))
                .andExpect(jsonPath("$.dislikeCount", is(review.getDislikeCount()+1)));
    }

    @Test
    void should_update_existing_review() throws Exception {
        ProductReview productReview = ProductReview.builder()
                .comment("About Product!!!")
                .rating(1)
                .build();

        ResultActions response = mockMvc.perform(put("/api/v1/review/10")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productReview)));


        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.comment", is(productReview.getComment())))
                .andExpect(jsonPath("$.rating", is(productReview.getRating())));
    }

    @Test
    void should_throw_exception_on_liking_invalid_review() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/review/dislike/2000"));


        response.andExpect(status().is4xxClientError())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Invalid Review, Review Dosent Exist")));

    }

    @Test
    void should_fetch_reviews_for_valid_product_with_average_strategy() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/review/5"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.rating", is(3.3)))
                .andExpect(jsonPath("$.ratingCount.1", is(2)))
                .andExpect(jsonPath("$.ratingCount.5", is(3)))
                .andExpect(jsonPath("$.productReviews[0].buyerName", is("Rohan")))
                .andExpect(jsonPath("$.productReviews[0].rating", is(5)))
                .andExpect(jsonPath("$.productReviews[1].likeCount", is(50)))
                .andExpect(jsonPath("$.productReviews[1].disLikeCount", is(150)));
    }

    @Test
    void should_fetch_reviews_for_valid_product_with_weighted_average_strategy() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/review/5")
                .queryParam("aggregationMethod", "WEIGHTED_AVERAGE"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.rating", is(3.14)))
                .andExpect(jsonPath("$.ratingCount.1", is(2)))
                .andExpect(jsonPath("$.ratingCount.5", is(3)))
                .andExpect(jsonPath("$.productReviews[0].buyerName", is("Rohan")))
                .andExpect(jsonPath("$.productReviews[0].rating", is(5)))
                .andExpect(jsonPath("$.productReviews[1].likeCount", is(50)))
                .andExpect(jsonPath("$.productReviews[1].disLikeCount", is(150)));
    }

}

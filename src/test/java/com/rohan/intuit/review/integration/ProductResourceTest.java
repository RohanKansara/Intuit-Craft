package com.rohan.intuit.review.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohan.intuit.review.entity.Product;
import com.rohan.intuit.review.entity.Seller;
import com.rohan.intuit.review.repository.db.DBProductRepositoryService;
import com.rohan.intuit.review.repository.db.DBSellerRepositoryService;
import com.rohan.intuit.review.request.ProductCatalog;
import com.rohan.intuit.review.utils.ProductCategory;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductResourceTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DBSellerRepositoryService dbSellerRepositoryService;

    @Test
    void should_create_product() throws Exception {
        ProductCatalog product = ProductCatalog.builder()
                .name("IPHONE")
                .productCategory(ProductCategory.MOBILE)
                .price(5000)
                .specifications("16GB Ram, 256GB Storage")
                .sellerId(1L)
                .build();

        ResultActions response = mockMvc.perform(post("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.productCategory", is(String.valueOf(product.getProductCategory()))))
                .andExpect(jsonPath("$.price", is(product.getPrice())))
                .andExpect(jsonPath("$.specifications", is(product.getSpecifications())))
                .andExpect(jsonPath("$.seller.id", is(1)));
    }

    @Test
    void should_throw_exception_while_creating_product_and_invalid_seller() throws Exception {
        ProductCatalog product = ProductCatalog.builder()
                .name("IPHONE")
                .productCategory(ProductCategory.MOBILE)
                .price(5000)
                .specifications("16GB Ram, 256GB Storage")
                .sellerId(100L)
                .build();

        ResultActions response = mockMvc.perform(post("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)));

        response.andExpect(status().is4xxClientError())
                .andDo(print())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Invalid Seller, Seller Dosent Exist")));
    }


}

package com.rohan.intuit.review.request;

import com.rohan.intuit.review.utils.ProductCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCatalog {

    private String name;

    private String specifications;

    private double price;

    private ProductCategory productCategory;

    Long sellerId;
}

package com.rohan.intuit.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rohan.intuit.review.utils.ProductCategory;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
@AllArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(name="product_sequence", sequenceName = "product_sequence", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String specifications;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    Seller seller;

    private double price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Review> reviews;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

}

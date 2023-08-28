package com.rohan.intuit.review.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "review")
@AllArgsConstructor
public class Review {
    @Id
    @SequenceGenerator(name="review_sequence", sequenceName = "review_sequence", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_sequence")
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int rating;

    @Column(length = 1000)
    private String comment;

    private int likeCount=0;

    private int dislikeCount=0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    @JsonIgnore
    private Buyer buyer;

    @CreationTimestamp
    @Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
    private Date timeStamp;
}

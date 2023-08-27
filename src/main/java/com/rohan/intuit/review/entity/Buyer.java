package com.rohan.intuit.review.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "buyer")
@AllArgsConstructor
public class Buyer {

    @Id
    @SequenceGenerator(name="buyer_sequence", sequenceName = "buyer_sequence", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyer_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private boolean certifiedBuyer;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Review> reviews;

}

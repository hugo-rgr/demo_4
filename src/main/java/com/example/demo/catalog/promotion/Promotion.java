package com.example.demo.catalog.promotion;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table
@Setter
@Getter
@Check(constraints = "start_date <= end_date")
public class Promotion {
    @SequenceGenerator(
            name = "promotion",
            schema = "public",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(nullable = false)
    private int discountPercentage;

}

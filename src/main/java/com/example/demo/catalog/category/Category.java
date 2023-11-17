package com.example.demo.catalog.category;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
public class Category {
    @SequenceGenerator(
            name = "category",
            schema = "public",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String label;


    public Category(String label) {
        this.label = label;
    }

    public Category() {

    }
}

package com.product.management.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}

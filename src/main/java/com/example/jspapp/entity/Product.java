package com.example.jspapp.entity;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long productID;
    private String name;
    private String description;
    private BigDecimal price;
    private Long fk_categoryID;
}

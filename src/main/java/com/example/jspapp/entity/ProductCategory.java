package com.example.jspapp.entity;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    private Long categoryID;
    private String name;
    private String description;
}

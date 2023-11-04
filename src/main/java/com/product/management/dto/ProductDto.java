package com.product.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private String productVersion;
    private String productDescription;
    private String productCompany;
    private Long categoryId;

}

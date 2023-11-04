package com.product.management.mapper;

import com.product.management.dto.ProductDto;
import com.product.management.entity.Product;

public class ProductMapper {
    public static final Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setProductVersion(productDto.getProductVersion());
        product.setProductDescription(productDto.getProductDescription());
        product.setProductCompany(productDto.getProductCompany());
        return product;
    }

    public static final ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getProductVersion(),
                product.getProductDescription(),
                product.getProductDescription(),
                product.getCategory().getId()
        );
        return productDto;
    }
}

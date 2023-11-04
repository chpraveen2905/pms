package com.product.management.service;

import com.product.management.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto addProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long id, ProductDto productDto);

    void removeProductById(Long id);
}

package com.product.management.service.impl;

import com.product.management.dao.CategoryRepository;
import com.product.management.dao.ProductRepository;
import com.product.management.dto.ProductDto;
import com.product.management.entity.Category;
import com.product.management.entity.Product;
import com.product.management.exception.ResourceNotFoundException;
import com.product.management.mapper.ProductMapper;
import com.product.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(
                () -> new ResourceNotFoundException("Category Not Found with Id : " + productDto.getCategoryId()));
        Product product = ProductMapper.mapToProduct(productDto);
        product.setCategory(category);
        return ProductMapper.mapToProductDto(productRepository.save(product));
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product Not Found with Id : " + id)
        );
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {

        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product Not Found with Id : " + id)
        );
        product.setProductCompany(productDto.getProductCompany());
        product.setProductDescription(productDto.getProductDescription());
        product.setProductVersion(productDto.getProductVersion());
        product.setProductName(productDto.getProductName());
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(
                () -> new ResourceNotFoundException("Category Not Found with Id : " + productDto.getCategoryId()));
        product.setCategory(category);
        Product updatedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public void removeProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product Not Found with Id : " + id)
        );
        productRepository.delete(product);
    }
}

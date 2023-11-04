package com.product.management.controller;

import com.product.management.dto.ProductDto;
import com.product.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto productDto1 = productService.addProduct(productDto);
        return new ResponseEntity<ProductDto>(productDto1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> fetchProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> fetchProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> modifyProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto) {

        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.removeProductById(id);
        return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);
    }

}

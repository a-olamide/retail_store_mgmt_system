package org.olamide.retailstoremgmtsystem.controller;

import lombok.AllArgsConstructor;
import org.olamide.retailstoremgmtsystem.api.ApiResponse;
import org.olamide.retailstoremgmtsystem.dto.product.ProductRequestDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductResponseDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductWithCategoriesResponseDto;
import org.olamide.retailstoremgmtsystem.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = {"/zrsms/api/v1/products"})
public class ProductController {
    private final ProductService productService;


    @GetMapping(value="")
    public ResponseEntity<ApiResponse<List<ProductWithCategoriesResponseDto>>> getAllProducts() {
        return ResponseEntity.ok(ApiResponse.ok(productService.getAllProductsWithCategories()));
    }

    @PostMapping(value="")
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(@RequestBody ProductRequestDto product) {
        return ResponseEntity.ok(ApiResponse.created(productService.createProduct(product)));
    }


}

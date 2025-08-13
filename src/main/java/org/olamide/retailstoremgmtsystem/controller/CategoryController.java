package org.olamide.retailstoremgmtsystem.controller;

import lombok.AllArgsConstructor;
import org.olamide.retailstoremgmtsystem.api.ApiResponse;
import org.olamide.retailstoremgmtsystem.dto.category.CategoryRequestDto;
import org.olamide.retailstoremgmtsystem.dto.category.CategoryResponseDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductRequestDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductResponseDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductWithCategoriesResponseDto;
import org.olamide.retailstoremgmtsystem.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = {"/zrsms/api/v1/categories"})
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping(value="")
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategories() {
        return ResponseEntity.ok(ApiResponse.ok(categoryService.getAllCategories()));
    }
    @PostMapping(value="")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> createCategory(@RequestBody CategoryRequestDto category) {
        return ResponseEntity.ok(ApiResponse.created(categoryService.createCategory(category)));
    }
}

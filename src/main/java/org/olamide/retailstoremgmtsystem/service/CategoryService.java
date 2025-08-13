package org.olamide.retailstoremgmtsystem.service;

import org.olamide.retailstoremgmtsystem.dto.category.CategoryRequestDto;
import org.olamide.retailstoremgmtsystem.dto.category.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto getCategory(int id);
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
}

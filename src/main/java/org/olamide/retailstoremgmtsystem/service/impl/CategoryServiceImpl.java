package org.olamide.retailstoremgmtsystem.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.olamide.retailstoremgmtsystem.dto.category.CategoryRequestDto;
import org.olamide.retailstoremgmtsystem.dto.category.CategoryResponseDto;
import org.olamide.retailstoremgmtsystem.model.Category;
import org.olamide.retailstoremgmtsystem.repository.CategoryRepository;
import org.olamide.retailstoremgmtsystem.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(
                c -> new CategoryResponseDto(
                        c.getCategoryId(),
                        c.getName()
                )
        ).toList();
    }

    @Override
    public CategoryResponseDto getCategory(int id) {
        var category = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return new CategoryResponseDto(category.getCategoryId(), category.getName());
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto dto) {
        var category = categoryRepository.findByName(dto.name());
        if (category == null) {
            category = new Category(dto.name());
            var saved = categoryRepository.save(category);
            return new CategoryResponseDto(saved.getCategoryId(), saved.getName());
        }
        return new CategoryResponseDto(category.getCategoryId(), category.getName());
    }
}

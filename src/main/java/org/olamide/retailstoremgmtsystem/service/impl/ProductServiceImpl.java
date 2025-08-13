package org.olamide.retailstoremgmtsystem.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.olamide.retailstoremgmtsystem.dto.category.CategoryResponseDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductRequestDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductResponseDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductWithCategoriesResponseDto;
import org.olamide.retailstoremgmtsystem.model.Category;
import org.olamide.retailstoremgmtsystem.model.Product;
import org.olamide.retailstoremgmtsystem.repository.CategoryRepository;
import org.olamide.retailstoremgmtsystem.repository.ProductRepository;
import org.olamide.retailstoremgmtsystem.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(p -> new ProductResponseDto(
                        p.getProductId(),
                        p.getSku(),
                        p.getProductName(),
                        p.getDateAcquired(),
                        p.getUnitPrice(),
                        p.getQuantityInStock(),
                        p.getUnitPrice() * p.getQuantityInStock()
                )).toList();
    }

    @Override
    public List<ProductWithCategoriesResponseDto> getAllProductsWithCategories() {
        return productRepository.findAll().stream()
                .map(p -> new ProductWithCategoriesResponseDto(
                        p.getProductId(),
                        p.getSku(),
                        p.getProductName(),
                        p.getDateAcquired(),
                        p.getUnitPrice(),
                        p.getQuantityInStock(),
                        p.getUnitPrice() * p.getQuantityInStock(),
                        p.getProductCategories().stream().map(
                                c -> new CategoryResponseDto(
                                        c.getCategoryId(),
                                        c.getName()
                                )
                        ).toList()
                )).toList();
    }

    @Override
    public ProductWithCategoriesResponseDto getProduct(Long productId) {
        productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        return null;
    }

    @Transactional
    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) {
        var product = new Product(dto.sku(),
                dto.productName(),
                dto.dateAcquired(),
                dto.unitPrice(),
                dto.quantityInStock());
        if(dto.categoryId() != null) {
            var category = categoryRepository.findById(dto.categoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
            var categorySet = new HashSet<Category>();
            categorySet.add(category);
            product.setProductCategories(categorySet);
        }
        var saved = productRepository.save(product);
        return new ProductResponseDto(
                saved.getProductId(),
                saved.getSku(),
                saved.getProductName(),
                saved.getDateAcquired(),
                saved.getUnitPrice(),
                saved.getQuantityInStock(),
                saved.getUnitPrice() * saved.getQuantityInStock()
        );
    }
}

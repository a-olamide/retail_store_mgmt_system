package org.olamide.retailstoremgmtsystem.service;

import org.olamide.retailstoremgmtsystem.dto.product.ProductRequestDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductResponseDto;
import org.olamide.retailstoremgmtsystem.dto.product.ProductWithCategoriesResponseDto;
import org.olamide.retailstoremgmtsystem.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    List<ProductWithCategoriesResponseDto> getAllProductsWithCategories();
    ProductWithCategoriesResponseDto getProduct(Long productId);
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
}

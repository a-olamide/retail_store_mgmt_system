package org.olamide.retailstoremgmtsystem.dto.product;

import org.olamide.retailstoremgmtsystem.dto.category.CategoryResponseDto;

import java.time.LocalDate;
import java.util.List;

public record ProductWithCategoriesResponseDto(
        Long productId,
        String sku,
        String productName,
        LocalDate dateAcquired,
        Double unitPrice,
        Integer quantityInStock,
        Double totalValue,
        List<CategoryResponseDto> categories
) {
}

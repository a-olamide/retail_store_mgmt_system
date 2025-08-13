package org.olamide.retailstoremgmtsystem.dto.product;

import java.time.LocalDate;

public record ProductResponseDto(
        Long productId,
        String sku,
        String productName,
        LocalDate dateAcquired,
        Double unitPrice,
        Integer quantityInStock,
        Double totalValue
) {
}

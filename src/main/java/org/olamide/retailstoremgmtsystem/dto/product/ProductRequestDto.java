package org.olamide.retailstoremgmtsystem.dto.product;

import java.time.LocalDate;

public record ProductRequestDto(
        String sku,
        String productName,
        LocalDate dateAcquired,
        Double unitPrice,
        Integer quantityInStock,
        Integer categoryId
) {
}

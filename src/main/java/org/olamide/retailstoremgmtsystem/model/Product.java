package org.olamide.retailstoremgmtsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false)
    @NotBlank(message = "SKU cannot be empty")
    private String sku;
    @Column(nullable = false)
    @NotBlank(message = "Product name cannot be empty")
    private String productName;
    @Column(nullable = false)
    @NotBlank(message = "Date acquired cannot be empty")
    private LocalDate dateAcquired;
    @Column(nullable = false)
    @NotBlank(message = "Unit price cannot be empty")
    private Double unitPrice;
    @Column(nullable = false)
    @NotBlank(message = "Quantity in stock cannot be empty")
    private Integer quantityInStock;
    @ManyToMany
    @JoinTable(
            name="product_categories",
            joinColumns = {@JoinColumn(name="product_id", referencedColumnName = "productd")},
            inverseJoinColumns = {@JoinColumn(name="category_id", referencedColumnName = "categoryId")},
            uniqueConstraints ={@UniqueConstraint(columnNames = {"product_id","category_id"})}
    )
    @ToString.Exclude
    private Set<Category> productCategories = new HashSet<>();
}

package org.olamide.retailstoremgmtsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(nullable = false)
    @NotBlank(message = "Category name cannot be empty")
    private String name;
    @ManyToMany(mappedBy = "productCategories")
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}

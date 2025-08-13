package org.olamide.retailstoremgmtsystem.repository;

import org.olamide.retailstoremgmtsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByProductCategories_CategoryId(Integer categoryId);
}

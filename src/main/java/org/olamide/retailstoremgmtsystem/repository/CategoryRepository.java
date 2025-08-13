package org.olamide.retailstoremgmtsystem.repository;

import org.olamide.retailstoremgmtsystem.model.Category;
import org.olamide.retailstoremgmtsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value= """
            Select c from Category c LEFT JOIN FETCH c.products order by c.name
            """)
    List<Category> getAllCategoriesAndProducts();
    Category findByName(String name);
}

package com.batuhankiltac.northwind.repository;

import com.batuhankiltac.northwind.entity.Product;
import com.batuhankiltac.northwind.model.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, Integer categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, Integer categoryId);
    List<Product> getByCategory_CategoryId_In(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);
    @Query("Select new com.batuhankiltac.northwind.entity.dto.ProductWithCategoryDto" +
            "(p.productId, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
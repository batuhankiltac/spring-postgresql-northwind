package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.entity.Product;
import com.batuhankiltac.northwind.entity.dto.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> getAllByPage(Integer pageNo, Integer pageSize);
    List<Product> getAllBySorted();
    Product add(Product product);
    Product update(Product product);
    void delete(Product product);
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, Integer categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, Integer categoryId);
    List<Product> getByCategory_CategoryId_In(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
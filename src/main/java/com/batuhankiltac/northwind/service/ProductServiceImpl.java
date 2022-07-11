package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.entity.Product;
import com.batuhankiltac.northwind.entity.dto.ProductWithCategoryDto;
import com.batuhankiltac.northwind.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllByPage(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Product> getAllBySorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        return productRepository.findAll(sort);
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        this.productRepository.findById(product.getProductId());
        product.setProductId(product.getProductId());
        product.setProductName(product.getProductName());
        product.setCategory(product.getCategory());
        product.setQuantityPerUnit(product.getQuantityPerUnit());
        product.setUnitPrice(product.getUnitPrice());
        product.setUnitsInStock(product.getUnitsInStock());
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product getByProductName(String productName) {
        return productRepository.getByProductName(productName);
    }

    @Override
    public Product getByProductNameAndCategory_CategoryId(String productName, Integer categoryId) {
        return productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @Override
    public List<Product> getByProductNameOrCategory_CategoryId(String productName, Integer categoryId) {
        return productRepository.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @Override
    public List<Product> getByCategory_CategoryId_In(List<Integer> categories) {
        return productRepository.getByCategory_CategoryId_In(categories);
    }

    @Override
    public List<Product> getByProductNameContains(String productName) {
        return productRepository.getByProductNameContains(productName);
    }

    @Override
    public List<Product> getByProductNameStartsWith(String productName) {
        return productRepository.getByProductNameStartsWith(productName);
    }

    @Override
    public List<ProductWithCategoryDto> getProductWithCategoryDetails() {
        return productRepository.getProductWithCategoryDetails();
    }
}
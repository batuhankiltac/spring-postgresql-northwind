package com.batuhankiltac.northwind.controller;

import com.batuhankiltac.northwind.entity.Product;
import com.batuhankiltac.northwind.model.ProductWithCategoryDto;
import com.batuhankiltac.northwind.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/by-page")
    public List<Product> getAllByPage(@Valid @RequestParam Integer pageNo, @Valid @RequestParam Integer pageSize) {
        return productService.getAllByPage(pageNo, pageSize);
    }

    @GetMapping("/by-sorted")
    public List<Product> getAllBySorted() {
        return productService.getAllBySorted();
    }

    @PostMapping
    public Product add(@Valid @RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping
    public Product update(@Valid @RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        productService.delete(id);
    }

    @GetMapping("/by-name")
    public Product getByProductName(@Valid @RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/by-name-and-category-id")
    public Product getByProductNameAndCategory_CategoryId(@Valid @RequestParam String productName, @Valid @RequestParam Integer categoryId) {
        return productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/by-name-or-category-id")
    public List<Product> getByProductNameOrCategory_CategoryId(@Valid @RequestParam String productName, @Valid @RequestParam Integer categoryId) {
        return productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/by-category-id-in")
    public List<Product> getByCategory_CategoryId_In(@Valid @RequestParam List<Integer> categories) {
        return productService.getByCategory_CategoryId_In(categories);
    }

    @GetMapping("/by-name-contains")
    public List<Product> getByProductNameContains(@Valid @RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/by-name-starts-with")
    public List<Product> getByProductNameStartsWith(@Valid @RequestParam String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/with-category-details")
    public List<ProductWithCategoryDto> getProductWithCategoryDetails() {
        return productService.getProductWithCategoryDetails();
    }
}
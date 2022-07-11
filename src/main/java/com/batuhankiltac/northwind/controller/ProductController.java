package com.batuhankiltac.northwind.controller;

import com.batuhankiltac.northwind.entity.Product;
import com.batuhankiltac.northwind.entity.dto.ProductWithCategoryDto;
import com.batuhankiltac.northwind.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getAllByPage")
    public List<Product>  getAllByPage(@Valid @RequestParam Integer pageNo, @Valid @RequestParam Integer pageSize) {
        return productService.getAllByPage(pageNo, pageSize);
    }

    @GetMapping("/getAllBySorted")
    public List<Product>  getAllBySorted() {
        return productService.getAllBySorted();
    }

    @PostMapping("/add")
    public Product add(@Valid @RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping("/update")
    public Product update(@Valid @RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/delete")
    public void delete(@Valid @RequestBody Product product) {
        productService.delete(product);
    }

    @GetMapping("/getByProductName")
    public Product getByProductName(@Valid @RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public Product getByProductNameAndCategory_CategoryId(@Valid @RequestParam String productName, @Valid @RequestParam Integer categoryId) {
        return productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public List<Product> getByProductNameOrCategory_CategoryId(@Valid @RequestParam String productName, @Valid @RequestParam Integer categoryId) {
        return productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryIn")
    public List<Product> getByCategory_CategoryId_In(@Valid @RequestParam List<Integer> categories) {
        return productService.getByCategory_CategoryId_In(categories);
    }

    @GetMapping("/getByProductNameContains")
    public List<Product> getByProductNameContains(@Valid @RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public List<Product> getByProductNameStartsWith(@Valid @RequestParam String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getProductWithCategoryDetails")
    public List<ProductWithCategoryDto> getProductWithCategoryDetails() {
        return productService.getProductWithCategoryDetails();
    }
}
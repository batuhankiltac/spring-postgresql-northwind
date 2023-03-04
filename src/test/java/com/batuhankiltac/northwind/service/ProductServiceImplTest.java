package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.entity.Category;
import com.batuhankiltac.northwind.entity.Product;
import com.batuhankiltac.northwind.model.ProductWithCategoryDto;
import com.batuhankiltac.northwind.repository.ProductRepository;
import com.batuhankiltac.northwind.service.product.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void it_should_get_all_products() {
        // Given
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product1 = Product.builder()
                .productId(1)
                .productName("test-product1")
                .category(category)
                .unitPrice(1.25)
                .build();
        final Product product2 = Product.builder()
                .productId(2)
                .productName("test-product2")
                .category(category)
                .unitPrice(1.25)
                .build();
        final List<Product> products = Arrays.asList(product1, product2);

        // When
        productServiceImpl.getAll();

        // Then
        verify(productRepository).findAll();
        assertThat(products).isNotEmpty();
        assertThat(product1.getProductId()).isNotEqualTo(product2.getProductId());
        assertThat(product2.getProductName()).isEqualTo("test-product2");
    }

    @Test
    public void it_should_save_product() {
        // Given
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();

        // When
        productServiceImpl.add(product);

        // Then
        verify(productRepository).save(product);
    }

    @Test
    public void it_should_update_product() {
        // Given
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product1 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final Product product2 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        when(productRepository.findById(product1.getProductId())).thenReturn(Optional.of(product2));

        // When
        productServiceImpl.update(product1);

        // Then
        verify(productRepository).findById(product1.getProductId());
        verify(productRepository).save(product2);
    }

    @Test
    public void it_should_delete_product() {
        // Given
        final Product product = Product.builder()
                .productId(1)
                .build();

        // When
        productServiceImpl.delete(product.getProductId());

        // Then
        verify(productRepository).deleteById(product.getProductId());
    }

    @Test
    public void it_should_get_by_product_name() {
        // Given
        final String productName = "test-product-name";
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        when(productRepository.getByProductName(productName)).thenReturn(product);

        // When
        productServiceImpl.getByProductName(productName);

        // Then
        verify(productRepository).getByProductName(productName);
    }

    @Test
    public void it_should_get_by_product_name_and_category_id() {
        // Given
        final String productName = "test-product-name";
        final Integer categoryId = 10;
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        when(productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId)).thenReturn(product);

        // When
        productServiceImpl.getByProductNameAndCategory_CategoryId(productName, categoryId);

        // Then
        verify(productRepository).getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @Test
    public void it_should_get_by_product_name_or_category_id() {
        // Given
        final String productName = "test-product-name";
        final Integer categoryId = 10;
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product1 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final Product product2 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final List<Product> products = Arrays.asList(product1, product2);
        when(productRepository.getByProductNameOrCategory_CategoryId(productName, categoryId)).thenReturn(products);

        // When
        productServiceImpl.getByProductNameOrCategory_CategoryId(productName, categoryId);

        // Then
        verify(productRepository).getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @Test
    public void it_should_get_by_category_id_in() {
        // Given
        final Integer categoryId1 = 10;
        final Integer categoryId2 = 10;
        final Integer categoryId3 = 10;
        List<Integer> categoryIds = Arrays.asList(categoryId1, categoryId2, categoryId3);
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product1 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final Product product2 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final List<Product> products = Arrays.asList(product1, product2);
        when(productRepository.getByCategory_CategoryId_In(categoryIds)).thenReturn(products);

        // When
        productServiceImpl.getByCategory_CategoryId_In(categoryIds);

        // Then
        verify(productRepository).getByCategory_CategoryId_In(categoryIds);
    }

    @Test
    public void it_should_get_by_product_name_contains() {
        // Given
        final String productName = "test-product-name";
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product1 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final Product product2 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final List<Product> products = Arrays.asList(product1, product2);
        when(productRepository.getByProductNameContains(productName)).thenReturn(products);

        // When
        productServiceImpl.getByProductNameContains(productName);

        // Then
        verify(productRepository).getByProductNameContains(productName);
    }

    @Test
    public void it_should_get_by_product_name_starts_with() {
        // Given
        final String productName = "test-product-name";
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test-category")
                .build();
        final Product product1 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final Product product2 = Product.builder()
                .productId(1)
                .productName("test-product")
                .category(category)
                .unitPrice(1.25)
                .build();
        final List<Product> products = Arrays.asList(product1, product2);
        when(productRepository.getByProductNameStartsWith(productName)).thenReturn(products);

        // When
        productServiceImpl.getByProductNameStartsWith(productName);

        // Then
        verify(productRepository).getByProductNameStartsWith(productName);
    }

    @Test
    public void it_should_get_product_with_category_details() {
        // Given
        final ProductWithCategoryDto productWithCategoryDto = ProductWithCategoryDto.builder().build();
        final List<ProductWithCategoryDto> productWithCategoryDtos = Collections.singletonList(productWithCategoryDto);
        when(productRepository.getProductWithCategoryDetails()).thenReturn(productWithCategoryDtos);

        // When
        productServiceImpl.getProductWithCategoryDetails();

        // Then
        verify(productRepository).getProductWithCategoryDetails();
    }
}
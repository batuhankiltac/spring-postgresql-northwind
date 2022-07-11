package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.entity.Category;
import com.batuhankiltac.northwind.entity.Product;
import com.batuhankiltac.northwind.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

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
        when(productServiceImpl.add(product)).thenReturn(product);

        // Then
        assertThat(product.getCategory()).isNotNull();
        assertThat(product.getUnitPrice()).isEqualTo(1.25);
    }

    @Test
    public void it_should_delete_product() {
        // Given
        final Product product = Product.builder().build();

        // When
        productServiceImpl.delete(product);

        // Then
        verify(productRepository).delete(product);
    }

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
        final List<Product> all = new ArrayList<>();
        all.add(product1);
        all.add(product2);

        // When
        when(productServiceImpl.getAll()).thenReturn(all);

        // Then
        assertThat(product1.getProductId()).isNotEqualTo(product2.getProductId());
        assertThat(product2.getProductName()).isEqualTo("test-product2");
    }
}
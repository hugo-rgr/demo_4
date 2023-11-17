package com.example.demo.catalog.product;

import com.example.demo.catalog.category.Category;
import com.example.demo.catalog.category.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    public void testSaveAndRetrieveProduct() {
        Category category = new Category("Test Category");
        categoryRepository.save(category);

        Product product = new Product();
        product.setLabel("Test Product");
        product.setDescription("Product description");
        product.setPrice(20.0);
        product.setImageURL("test.jpg");
        product.setCategory(category);

        productRepository.save(product);

        Product retrievedProduct = productRepository.findById(product.getId()).orElse(null);

        assertThat(retrievedProduct).isNotNull();
        assertThat(retrievedProduct.getId()).isEqualTo(product.getId());
        assertThat(retrievedProduct.getLabel()).isEqualTo("Test Product");
        assertThat(retrievedProduct.getDescription()).isEqualTo("Product description");
        assertThat(retrievedProduct.getPrice()).isEqualTo(20.0);
        assertThat(retrievedProduct.getImageURL()).isEqualTo("test.jpg");
        assertThat(retrievedProduct.getCategory().getLabel()).isEqualTo("Test Category");
    }

    @Test
    @Transactional
    public void testFindByCategoryLabel() {
        String categoryLabel = "Test Category 2";
        Category category = new Category(categoryLabel);
        categoryRepository.save(category);

        Product product = new Product();
        product.setLabel("Test Product");
        product.setDescription("Product description");
        product.setPrice(20.0);
        product.setImageURL("test.jpg");
        product.setCategory(category);

        Product product2 = new Product();
        product2.setLabel("Test Product2");
        product2.setDescription("Product description2");
        product2.setPrice(25.0);
        product2.setImageURL("test2.jpg");
        product2.setCategory(category);

        productRepository.save(product);
        productRepository.save(product2);

        List<Product> products = productRepository.findByCategoryLabel(categoryLabel);

        for (Product p: products) {
            System.out.println(p.getLabel());
        }

        Assertions.assertThat(products).hasSize(2);
    }
}




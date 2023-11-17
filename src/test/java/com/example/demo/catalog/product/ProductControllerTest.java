package com.example.demo.catalog.product;

import com.example.demo.catalog.category.Category;
import com.example.demo.catalog.category.CategoryService;
import com.example.demo.catalog.promotion.Promotion;
import com.example.demo.catalog.promotion.PromotionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private CategoryService categoryService;

    @Mock
    private PromotionService promotionService;
    
    @InjectMocks
    private ProductController productController;

    public ProductControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateProduct() {

        Category category = new Category("Test Category");
        categoryService.createCategory(category);

        // without promotion
        Long productId = 1L;
        Product product1 = new Product();
        product1.setLabel("Updated Product");
        product1.setPrice(25.99);
        product1.setLabel("Test Product");
        product1.setDescription("Product description");
        product1.setPrice(20.0);
        product1.setImageURL("test.jpg");
        product1.setCategory(category);

        // with promotion
        Promotion promotion = new Promotion();
        promotion.setStartDate(LocalDate.parse("2023-11-13"));
        promotion.setEndDate(LocalDate.parse("2024-12-31"));
        promotion.setDiscountPercentage(10);
        promotionService.createPromotion(promotion);

        Long product2Id = 2L;
        Product product2 = new Product();
        product2.setLabel("Test Product 5555");
        product2.setDescription("Description lorem ipsum");
        product2.setPrice(13.55);
        product2.setImageURL("test42.jpg");
        product2.setCategory(category);
        product2.setPromotion(promotion);



        when(productService.updateProduct(eq(productId), any(Product.class))).thenReturn(product1);

        Product response = productController.updateProduct(productId, product1);
        verify(productService, times(1)).updateProduct(eq(productId), any(Product.class));

        when(productService.updateProduct(eq(product2Id), any(Product.class))).thenReturn(product2);

        Product response2 = productController.updateProduct(product2Id, product1);
        verify(productService, times(1)).updateProduct(eq(product2Id), any(Product.class));
    }


    @Test
    void testGetAllCategories() {
        Category category = new Category("Test Category");
        categoryService.createCategory(category);

        // without promotion
        Long productId = 1L;
        Product product1 = new Product();
        product1.setLabel("Updated Product");
        product1.setPrice(25.99);
        product1.setLabel("Test Product");
        product1.setDescription("Product description");
        product1.setPrice(20.0);
        product1.setImageURL("test.jpg");
        product1.setCategory(category);

        // with promotion
        Promotion promotion = new Promotion();
        promotion.setStartDate(LocalDate.parse("2023-11-13"));
        promotion.setEndDate(LocalDate.parse("2024-12-31"));
        promotion.setDiscountPercentage(10);
        promotionService.createPromotion(promotion);

        Long product2Id = 2L;
        Product product2 = new Product();
        product2.setLabel("Test Product 5555");
        product2.setDescription("Description lorem ipsum");
        product2.setPrice(13.55);
        product2.setImageURL("test42.jpg");
        product2.setCategory(category);
        product2.setPromotion(promotion);

        List<Product> products = Arrays.asList(product1, product2);

        when(productService.getAllProducts()).thenReturn(products);

        List<Product> response = productController.getAllProducts();

        verify(productService, times(1)).getAllProducts();
    }
}


package com.example.demo;

import com.example.demo.catalog.category.Category;
import com.example.demo.catalog.category.CategoryService;
import com.example.demo.catalog.product.Product;
import com.example.demo.catalog.product.ProductService;
import com.example.demo.catalog.promotion.Promotion;
import com.example.demo.catalog.promotion.PromotionService;
import com.example.demo.security.admin.Admin;
import com.example.demo.security.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInserts implements CommandLineRunner {

    private AdminService adminService;
    private CategoryService categoryService;
    private PromotionService promotionService;
    private ProductService productService;

    @Autowired
    public DataInserts(AdminService adminService, CategoryService categoryService, PromotionService promotionService, ProductService productService) {
        this.adminService = adminService;
        this.categoryService = categoryService;
        this.promotionService = promotionService;
        this.productService = productService;
    }

    public void dataInsertsForAdmin() {
        Admin admin1 = new Admin();
        admin1.setLogin("admin");
        admin1.setPass("lorem5ipsum");
        adminService.createAdmin(admin1);

        Admin admin2 = new Admin();
        admin2.setLogin("john_doe");
        admin2.setPass("coolmdp");
        adminService.createAdmin(admin2);
    }


    public void dataInsertsForCategory() {
        Category catFruits = new Category("Fruits et légumes");
        Category catBakery = new Category("Produits de boulangerie");

        categoryService.createCategory(catFruits);
        categoryService.createCategory(catBakery);
    }

    public void dataInsertsForPromotion() {
        Promotion prodTomatoPromotion = new Promotion();
        prodTomatoPromotion.setStartDate(LocalDate.parse("2023-11-13"));
        prodTomatoPromotion.setEndDate(LocalDate.parse("2024-12-31"));
        prodTomatoPromotion.setDiscountPercentage(10);
        promotionService.createPromotion(prodTomatoPromotion);

        Promotion prodPainChocolatPromotion = new Promotion();
        prodPainChocolatPromotion.setStartDate(LocalDate.parse("2022-01-23"));
        prodPainChocolatPromotion.setEndDate(LocalDate.parse("2022-12-31"));
        prodPainChocolatPromotion.setDiscountPercentage(25);
        promotionService.createPromotion(prodPainChocolatPromotion);
    }

    public void dataInsertsForProduct() {
        Category catFruits = categoryService.getCategoryById(1L).get();
        Category catBakery = categoryService.getCategoryById(2L).get();

        Promotion prodTomatoPromotion = promotionService.getPromotionById(1L).get();
        Promotion prodPainChocolatPromotion = promotionService.getPromotionById(2L).get();

        Product prodApple = new Product();
        prodApple.setLabel("Lot de 6 pommes Golden Delicious Bio");
        prodApple.setDescription("Prix au kg: 3.85€");
        prodApple.setPrice(3.20);
        prodApple.setImageURL("https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Golden_delicious_apple.jpg/500px-Golden_delicious_apple.jpg");
        prodApple.setCategory(catFruits);
        productService.createProduct(prodApple);

        Product prodTomato = new Product();
        prodTomato.setLabel("Tomates cerises mélangées 500g");
        prodTomato.setDescription("Cultivées en France. Prix au kg: 5.99 €");
        prodTomato.setPrice(3.25);
        //prodTomato.setImageURL(""); // didn't add one to show image alternative
        prodTomato.setCategory(catFruits);
        prodTomato.setPromotion(prodTomatoPromotion);
        productService.createProduct(prodTomato);

        Product prodPainChocolat = new Product();
        prodPainChocolat.setLabel("4 pains au chocolat");
        //prodPainChocolat.setDescription("");
        prodPainChocolat.setPrice(3.60);
        prodPainChocolat.setImageURL("https://upload.wikimedia.org/wikipedia/commons/a/ac/Corbeille_de_pains_au_chocolat.jpg?20200131201819");
        prodPainChocolat.setCategory(catBakery);
        prodPainChocolat.setPromotion(prodPainChocolatPromotion);
        productService.createProduct(prodPainChocolat);

    }

    @Override
    public void run(String... args) throws Exception {
        dataInsertsForAdmin();
        dataInsertsForCategory();
        dataInsertsForPromotion();
        dataInsertsForProduct();
    }
}

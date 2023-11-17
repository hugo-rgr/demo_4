package com.example.demo.catalog;

import com.example.demo.catalog.category.Category;
import com.example.demo.catalog.category.CategoryService;
import com.example.demo.catalog.product.Product;
import com.example.demo.catalog.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CatalogController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public CatalogController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @RequestMapping("/")
    public String viewCatalog(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Product> products = productService.getAllProducts();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("currentDate", LocalDate.now());
        return "catalog";
    }

}

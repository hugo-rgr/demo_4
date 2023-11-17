package com.example.demo.catalog.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/get/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getAll/category/{categoryLabel}")
    public List<Product> getAllProductsByCategoryLabel(@PathVariable String categoryLabel){
        return productService.getAllProductsByCategory(categoryLabel);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllProducts() {
        productService.deleteAllProducts();
        return "All products have been deleted successfully.";
    }

    @DeleteMapping("/deleteAll/category/{categoryId}")
    public String deleteProductsByCategoryLabel(@RequestParam Long categoryId) {
        productService.deleteAllProductsByCategoryLabel(categoryId);
        return "All products for selected category have been deleted successfully.";
    }
}

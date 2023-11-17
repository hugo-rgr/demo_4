package com.example.demo.catalog.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category user) {
        return categoryService.createCategory(user);
    }

    @GetMapping("/get/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/getAll")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/getLabels/")
    public List<Category> getAllCategoryLabels() {
        return categoryService.getAllCategories();
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(id, categoryDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllCategories() {
        categoryService.deleteAllCategories();
        return "All categories have been deleted successfully.";
    }

}

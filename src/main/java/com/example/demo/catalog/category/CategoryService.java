package com.example.demo.catalog.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            existingCategory.setLabel(categoryDetails.getLabel());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}

package com.example.demo.catalog.category;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    public CategoryControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCategories() {
        Category category1 = new Category("Category1");
        Category category2 = new Category("Category2");
        List<Category> categories = Arrays.asList(category1, category2);

        when(categoryService.getAllCategories()).thenReturn(categories);

        List<Category> response = categoryController.getAllCategories();

        verify(categoryService, times(1)).getAllCategories();
    }
}


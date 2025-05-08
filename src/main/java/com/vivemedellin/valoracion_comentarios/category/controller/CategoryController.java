package com.vivemedellin.valoracion_comentarios.category.controller;

import com.vivemedellin.valoracion_comentarios.category.dto.CategoryDTO;
import com.vivemedellin.valoracion_comentarios.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {

    private final  CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @QueryMapping
    public List<CategoryDTO> allCategories() {
        return categoryService.findAll();
    }
}

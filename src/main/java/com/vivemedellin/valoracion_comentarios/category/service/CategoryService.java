package com.vivemedellin.valoracion_comentarios.category.service;

import com.vivemedellin.valoracion_comentarios.category.dto.CategoryDTO;
import com.vivemedellin.valoracion_comentarios.category.entity.Category;
import com.vivemedellin.valoracion_comentarios.category.factory.CategoryMockFactory;
import com.vivemedellin.valoracion_comentarios.category.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    private final CategoryMockFactory mockFactory;

    @Autowired
    public CategoryService(CategoryRepository repository, CategoryMapper mapper, CategoryMockFactory mockFactory) {
        this.repository = repository;
        this.mapper = mapper;
        this.mockFactory = mockFactory;
    }

    public List<CategoryDTO> findAll() {
        var categories = repository.findAll();
        return categories.stream().map(mapper::toDTO).toList();
    }

    public List<CategoryDTO> populateDatabase(){
        var mocks = mockFactory.createMocks();
        return this.repository.saveAll(mocks).stream().map(mapper::toDTO).toList();
    }
}

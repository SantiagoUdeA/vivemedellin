package com.vivemedellin.valoracion_comentarios.shared.services;

import com.vivemedellin.valoracion_comentarios.category.service.CategoryService;
import com.vivemedellin.valoracion_comentarios.organizer.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopulateDatabaseService {

    private final OrganizerService organizerService;
    private final CategoryService categoryService;

    @Autowired
    public PopulateDatabaseService(OrganizerService organizerService, CategoryService categoryService) {
        this.organizerService = organizerService;
        this.categoryService = categoryService;
    }

    public void populateDatabase() {
        organizerService.populateDatabase();
        categoryService.populateDatabase();
        System.out.println("Database populated with fake data successfully");
    }
}

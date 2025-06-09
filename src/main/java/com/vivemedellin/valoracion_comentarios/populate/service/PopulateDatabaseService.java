package com.vivemedellin.valoracion_comentarios.populate.service;

import com.vivemedellin.valoracion_comentarios.category.dto.CategoryDTO;
import com.vivemedellin.valoracion_comentarios.category.service.CategoryService;
import com.vivemedellin.valoracion_comentarios.event.dto.EventDto;
import com.vivemedellin.valoracion_comentarios.event.service.EventService;
import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import com.vivemedellin.valoracion_comentarios.organizer.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulateDatabaseService {

    private final OrganizerService organizerService;
    private final CategoryService categoryService;
    private final EventService eventService;

    @Autowired
    public PopulateDatabaseService(OrganizerService organizerService, CategoryService categoryService, EventService eventService) {
        this.organizerService = organizerService;
        this.categoryService = categoryService;
        this.eventService = eventService;
    }

    public List<OrganizerDTO> populateOrganizers(){
        return this.organizerService.populateDatabase();
    }

    public List<CategoryDTO> populateCategories(){
        return this.categoryService.populateDatabase();
    }

    public EventDto populateEvents(){
        return this.eventService.populateDatabase();
    }

}

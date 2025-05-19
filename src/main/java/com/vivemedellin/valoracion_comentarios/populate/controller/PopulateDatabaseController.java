package com.vivemedellin.valoracion_comentarios.populate.controller;

import com.vivemedellin.valoracion_comentarios.category.dto.CategoryDTO;
import com.vivemedellin.valoracion_comentarios.event.dto.EventDTO;
import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import com.vivemedellin.valoracion_comentarios.populate.service.PopulateDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/populate")
public class PopulateDatabaseController {

    private final PopulateDatabaseService populateDatabaseService;

    @Autowired
    public PopulateDatabaseController(PopulateDatabaseService populateDatabaseService) {
        this.populateDatabaseService = populateDatabaseService;
    }

    @PostMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> populateCategories(){
        var categories = populateDatabaseService.populateCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/organizers")
    public ResponseEntity<List<OrganizerDTO>> populateOrganizers(){
        var organizers = populateDatabaseService.populateOrganizers();
        return ResponseEntity.ok(organizers);
    }

    @PostMapping("/events")
    public ResponseEntity<EventDTO> populateEvents(){
        var event = populateDatabaseService.populateEvents();
        return ResponseEntity.ok(event);
    }
}

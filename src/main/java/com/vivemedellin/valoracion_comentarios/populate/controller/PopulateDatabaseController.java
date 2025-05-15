package com.vivemedellin.valoracion_comentarios.populate.controller;

import com.vivemedellin.valoracion_comentarios.populate.service.PopulateDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populate")
public class PopulateDatabaseController {

    private final PopulateDatabaseService populateDatabaseService;

    @Autowired
    public PopulateDatabaseController(PopulateDatabaseService populateDatabaseService) {
        this.populateDatabaseService = populateDatabaseService;
    }

    @PostMapping("/categories")
    public ResponseEntity<String> populateDatabase(){
        populateDatabaseService.populateCategories();
        return ResponseEntity.ok("Categories populated successfully");
    }

    @PostMapping("/organizers")
    public ResponseEntity<String> populateOrganizers(){
        populateDatabaseService.populateOrganizers();
        return ResponseEntity.ok("Organizers populated successfully");
    }

    @PostMapping("/events")
    public ResponseEntity<String> populateEvents(){
        populateDatabaseService.populateEvents();
        return ResponseEntity.ok("Event populated successfully");
    }
}

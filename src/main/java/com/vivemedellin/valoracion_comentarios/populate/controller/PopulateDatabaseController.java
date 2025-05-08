package com.vivemedellin.valoracion_comentarios.populate.controller;

import com.vivemedellin.valoracion_comentarios.populate.service.PopulateDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PopulateDatabaseController {

    private final PopulateDatabaseService populateDatabaseService;

    @Autowired
    public PopulateDatabaseController(PopulateDatabaseService populateDatabaseService) {
        this.populateDatabaseService = populateDatabaseService;
    }

    @PostMapping("/populate")
    public ResponseEntity<String> populateDatabase(){
        populateDatabaseService.populateDatabase();
        return ResponseEntity.ok("Database populated successfully");
    }
}

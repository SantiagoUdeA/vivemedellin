package com.vivemedellin.valoracion_comentarios.organizer.controller;

import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import com.vivemedellin.valoracion_comentarios.organizer.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrganizerController {

    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @QueryMapping
    public List<OrganizerDTO> allOrganizers(){
        var a = organizerService.findAll();
        System.out.println(a);
        return a;
    }
}

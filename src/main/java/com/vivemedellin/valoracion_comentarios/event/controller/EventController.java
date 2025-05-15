package com.vivemedellin.valoracion_comentarios.event.controller;

import com.vivemedellin.valoracion_comentarios.event.dto.EventDTO;
import com.vivemedellin.valoracion_comentarios.event.service.EventService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @QueryMapping
    public List<EventDTO> allEvents(){
        return this.eventService.getAll();
    }
}

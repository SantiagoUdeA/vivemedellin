package com.vivemedellin.valoracion_comentarios.event.controller;

import com.vivemedellin.valoracion_comentarios.event.dto.EventWithReviewStatsDTO;
import com.vivemedellin.valoracion_comentarios.event.service.EventService;
import org.springframework.graphql.data.method.annotation.Argument;
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
    public List<EventWithReviewStatsDTO> allEvents(){
        return this.eventService.getAll();
    }

    @QueryMapping
    public EventWithReviewStatsDTO event(@Argument int eventId){
        return this.eventService.getById((long) eventId);
    }
}

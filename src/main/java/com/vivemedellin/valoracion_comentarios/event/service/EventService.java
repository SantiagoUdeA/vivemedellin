package com.vivemedellin.valoracion_comentarios.event.service;

import com.vivemedellin.valoracion_comentarios.admin.entity.Admin;
import com.vivemedellin.valoracion_comentarios.admin.repository.AdminRepository;
import com.vivemedellin.valoracion_comentarios.category.entity.Category;
import com.vivemedellin.valoracion_comentarios.category.service.CategoryRepository;
import com.vivemedellin.valoracion_comentarios.event.dto.EventDto;
import com.vivemedellin.valoracion_comentarios.event.dto.EventWithReviewStatsDTO;
import com.vivemedellin.valoracion_comentarios.event.factory.EventMockFactory;
import com.vivemedellin.valoracion_comentarios.event.mapper.EventMapper;
import com.vivemedellin.valoracion_comentarios.event.repository.EventRepository;
import com.vivemedellin.valoracion_comentarios.organizer.entity.Organizer;
import com.vivemedellin.valoracion_comentarios.organizer.repository.OrganizerRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
EventService {

    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;
    private final OrganizerRepository organizerRepository;
    private final AdminRepository adminRepository;
    private final EventMockFactory eventMockFactory;
    private final EventMapper eventMapper;

    @Autowired
    public EventService(EventRepository eventRepository, CategoryRepository categoryRepository, OrganizerRepository organizerRepository, AdminRepository adminRepository, EventMockFactory eventMockFactory, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
        this.organizerRepository = organizerRepository;
        this.adminRepository = adminRepository;
        this.eventMockFactory = eventMockFactory;
        this.eventMapper = eventMapper;
    }

    public List<EventWithReviewStatsDTO> getAll(){
        return eventRepository.findAllWithReviewStats();
    }

    public EventWithReviewStatsDTO getById(Long id){
        return eventRepository.findWithReviewStats(id);
    }

    public EventDto populateDatabase(){
        final Faker faker = new Faker();
        var categories = categoryRepository.findAll();
        var organizers = organizerRepository.findAll();
        var admins = adminRepository.findAll();

        if (categories.isEmpty()) {
            throw new IllegalStateException("No categories found. Cannot create event.");
        }

        if (organizers.isEmpty()) {
            throw new IllegalStateException("No organizers found. Cannot create event.");
        }

        if (admins.isEmpty()) {
            throw new IllegalStateException("No admins found. Cannot create event.");
        }

        var event = eventMockFactory.createEvent(
                (Admin) faker.options().option(admins.toArray()),
                (Category) faker.options().option(categories.toArray()),
                (Organizer)  faker.options().option(organizers.toArray())
        );

        return eventMapper.toDTO(eventRepository.save(event));
    }
}

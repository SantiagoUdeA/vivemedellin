package com.vivemedellin.valoracion_comentarios.organizer.service;

import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import com.vivemedellin.valoracion_comentarios.organizer.factory.OrganizerMockFactory;
import com.vivemedellin.valoracion_comentarios.organizer.mapper.OrganizerMapper;
import com.vivemedellin.valoracion_comentarios.organizer.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizerService {

    private final OrganizerRepository repository;
    private final OrganizerMapper mapper;
    private final OrganizerMockFactory organizerMockFactory;

    @Autowired
    public OrganizerService(OrganizerRepository repository, OrganizerMapper mapper, OrganizerMockFactory organizerMockFactory) {
        this.repository = repository;
        this.mapper = mapper;
        this.organizerMockFactory = organizerMockFactory;
    }

    public List<OrganizerDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public List<OrganizerDTO> populateDatabase(){
        List<OrganizerDTO> organizers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            organizers.add(mapper.toDTO(repository.save(organizerMockFactory.createMock())));
        }
        return organizers;
    }
}

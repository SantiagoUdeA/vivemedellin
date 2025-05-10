package com.vivemedellin.valoracion_comentarios.event.repository;

import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>{
}

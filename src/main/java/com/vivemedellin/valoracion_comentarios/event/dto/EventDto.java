package com.vivemedellin.valoracion_comentarios.event.dto;

import com.vivemedellin.valoracion_comentarios.admin.entity.AdminDto;
import com.vivemedellin.valoracion_comentarios.category.dto.CategoryDTO;
import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Event}
 */
@Data
public class EventDto implements Serializable {
    Long id;
    AdminDto admin;
    OrganizerDTO organizer;
    String title;
    String description;
    Instant date;
    String location;
    CategoryDTO category;
    BigDecimal price;
}
package com.vivemedellin.valoracion_comentarios.event.dto;

import com.vivemedellin.valoracion_comentarios.admin.entity.AdminDto;
import com.vivemedellin.valoracion_comentarios.category.dto.CategoryDTO;
import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Event}
 */
@Data
public class EventDTO implements Serializable {
    Long id;
    AdminDto admin;
    OrganizerDTO organizer;
    @Size(max = 100)
    @Length(max = 100)
    String title;
    String description;
    Instant date;
    @Size(max = 100)
    @Length(max = 100)
    String location;
    CategoryDTO category;
    @Digits(integer = 10, fraction = 2)
    @PositiveOrZero
    BigDecimal price;
}
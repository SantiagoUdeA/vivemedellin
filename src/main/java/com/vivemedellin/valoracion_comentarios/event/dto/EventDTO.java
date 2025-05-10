package com.vivemedellin.valoracion_comentarios.event.dto;

import com.vivemedellin.valoracion_comentarios.admin.entity.AdminDto;
import com.vivemedellin.valoracion_comentarios.category.dto.CategoryDTO;
import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import jakarta.validation.constraints.*;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Event}
 */
@Value
public class EventDTO implements Serializable {
    Long id;
    AdminDto admin;
    OrganizerDTO organizer;
    @NotNull
    @Size(max = 100)
    @NotEmpty
    @NotBlank
    @Length(max = 100)
    String title;
    String description;
    @NotNull
    Instant date;
    @NotNull
    @Size(max = 100)
    @NotEmpty
    @NotBlank
    @Length(max = 100)
    String location;
    CategoryDTO category;
    @NotNull
    @Digits(integer = 10, fraction = 2)
    @PositiveOrZero
    BigDecimal price;
}
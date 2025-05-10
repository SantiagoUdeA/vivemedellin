package com.vivemedellin.valoracion_comentarios.review.dto;

import com.vivemedellin.valoracion_comentarios.event.dto.EventDTO;
import com.vivemedellin.valoracion_comentarios.user.dto.UserDto;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.vivemedellin.valoracion_comentarios.review.entity.Review}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDto implements Serializable {
    @Positive
    private Long id;
    private UserDto user;
    private EventDTO event;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Positive
    @Range(min = 1, max = 5)
    private Integer rating;
    private String comment;
    private Instant createdAt;
    private Instant updatedAt;
}
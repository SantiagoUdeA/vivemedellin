package com.vivemedellin.valoracion_comentarios.review.dto;

import com.vivemedellin.valoracion_comentarios.event.dto.EventDto;
import com.vivemedellin.valoracion_comentarios.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long id;
    private UserDto user;
    private EventDto event;
    private Integer rating;
    private String comment;
    private Instant createdAt;
    private Instant updatedAt;
}
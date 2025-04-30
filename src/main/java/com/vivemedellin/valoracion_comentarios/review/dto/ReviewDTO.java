package com.vivemedellin.valoracion_comentarios.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;
    private int rating;
    private String commentary;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

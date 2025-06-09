package com.vivemedellin.valoracion_comentarios.moderation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateReviewModerationDto {
    private Long reviewId;
    private String comment;
}

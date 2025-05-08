package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateReviewCommand {
    private UUID userId;
    private Long eventId;
    private int rating;
    private String comment;
}

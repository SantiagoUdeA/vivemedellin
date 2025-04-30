package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateReviewCommand {
    private String userId;
    private Long eventId;
    private int rating;
    private String comment;
}

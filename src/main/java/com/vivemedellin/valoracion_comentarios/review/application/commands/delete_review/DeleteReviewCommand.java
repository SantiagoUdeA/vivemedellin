package com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DeleteReviewCommand {

    private Long eventId;
    private UUID userId;
}

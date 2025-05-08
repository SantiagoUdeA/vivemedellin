package com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteReviewCommand {

    private Long eventId;
    private String userId;
}

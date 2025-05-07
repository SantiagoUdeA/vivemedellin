package com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetReviewsByEventIdCommand {
    private Long eventId;
}

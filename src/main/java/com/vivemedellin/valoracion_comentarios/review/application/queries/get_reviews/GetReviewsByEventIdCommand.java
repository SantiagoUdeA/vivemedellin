package com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
public class GetReviewsByEventIdCommand {
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NonNull
    private Long eventId;
}

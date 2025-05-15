package com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DeleteReviewCommand {

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NonNull
    private Long eventId;
    @NonNull
    @org.hibernate.validator.constraints.UUID(version = 4)
    private UUID userId;
}

package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateReviewCommand {
    @org.hibernate.validator.constraints.UUID(version = 4)
    @NonNull
    private UUID userId;
    @NonNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Long eventId;
    @NonNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer rating;
    private String comment;
}

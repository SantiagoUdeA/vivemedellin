package com.vivemedellin.valoracion_comentarios.review.application.commands.update_review;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UpdateReviewCommand {
    @NotNull
    @NotBlank
    private Long reviewId;
    @NotNull
    private UUID userId;
    @Min(1)
    @Max(5)
    private Integer rating;
    @Size(max = 1000)
    private String comment;
}

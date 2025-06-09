package com.vivemedellin.valoracion_comentarios.review.application.queries.get_review_by_user_and_event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class GetUserReviewCommand {
    @NonNull
    private Long eventId;
    @NonNull
    @org.hibernate.validator.constraints.UUID(version = 4)
    private UUID userId;
}

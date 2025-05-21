package com.vivemedellin.valoracion_comentarios.event.dto;

import java.math.BigDecimal;
import java.time.Instant;

public interface EventWithReviewStatsDTO {
    Long getId();
    String getTitle();
    String getDescription();
    Instant getDate();
    String getLocation();
    BigDecimal getPrice();
    Long getTotalReviews();
    Double getAverageRating();
}

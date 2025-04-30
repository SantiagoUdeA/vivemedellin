package com.vivemedellin.valoracion_comentarios.review.factory;

import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;

import java.time.LocalDateTime;

public class ReviewMockFactory {

    public static Review createReview(Long id, String userId, Long eventId, int rating, String commentary) {
        Review review = new Review();
        review.setId(id);
        review.setRating(rating);
        review.setComment(commentary);
        review.setUserId(userId);
        review.setEventId(eventId);
        return review;
    }

    public static ReviewDTO createReviewDTO(Long id, String userId, Long eventId, int rating, String commentary) {
        return new ReviewDTO(id, userId, eventId, rating, commentary, LocalDateTime.now(), LocalDateTime.now());
    }
}

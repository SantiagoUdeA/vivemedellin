package com.vivemedellin.valoracion_comentarios.review.factory;

import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;

import java.time.LocalDateTime;

public class ReviewMockFactory {

    public static Review createReview(Long id, int rating, String commentary) {
        Review review = new Review();
        review.setId(id);
        review.setRating(rating);
        review.setComment(commentary);
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return review;
    }

    public static ReviewDTO createReviewDTO(Long id, int rating, String commentary) {
        return new ReviewDTO(id, rating, commentary, LocalDateTime.now(), LocalDateTime.now());
    }
}

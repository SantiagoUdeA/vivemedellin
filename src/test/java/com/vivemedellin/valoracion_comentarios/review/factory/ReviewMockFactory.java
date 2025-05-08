package com.vivemedellin.valoracion_comentarios.review.factory;

import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ReviewMockFactory {

    final Faker faker = new Faker();

    public static Review createReview(Long id, UUID userId, Long eventId, int rating, String commentary) {
        Review review = new Review();
        review.setId(id);
        review.setRating(rating);
        review.setComment(commentary);
        review.setUserId(userId);
        review.setEventId(eventId);
        return review;
    }

    public Review createReview(){
        var review = new Review();
        review.setUserId(UUID.fromString(faker.internet().uuid()));
        review.setEventId(faker.number().randomNumber());
        review.setRating(faker.number().numberBetween(1, 5));
        review.setComment(faker.lorem().sentence());
        return review;

    }

    public static ReviewDTO createReviewDTO(Long id, UUID userId, Long eventId, int rating, String commentary) {
        return new ReviewDTO(id, userId, eventId, rating, commentary, LocalDateTime.now(), LocalDateTime.now());
    }
}

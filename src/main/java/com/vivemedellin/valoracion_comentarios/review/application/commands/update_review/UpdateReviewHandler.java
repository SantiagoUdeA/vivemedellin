package com.vivemedellin.valoracion_comentarios.review.application.commands.update_review;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.review.exceptions.NotFoundReviewException;
import com.vivemedellin.valoracion_comentarios.review.exceptions.UpdateTimeLimitException;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class UpdateReviewHandler {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public UpdateReviewHandler(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewDto handle(@Valid UpdateReviewCommand command){
        var review = reviewRepository
                .findByIdAndUserId(command.getReviewId(), command.getUserId())
                .orElseThrow(() -> new NotFoundReviewException(command.getReviewId()));

        // User can't  edit if one 1 day has passed
        if (Duration.between(review.getCreatedAt(), Instant.now()).toDays() >= 1){
            throw new UpdateTimeLimitException();
        }

        // Partial update
        if (command.getRating() != null){
            review.setRating(command.getRating());
        }

        if(command.getComment() != null){
            review.setComment(command.getComment());
        }

        return reviewMapper.toDTO(reviewRepository.save(review));
    }
}

package com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.review.exceptions.NotFoundReviewException;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import com.vivemedellin.valoracion_comentarios.shared.exceptions.ForbiddenAccessException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteReviewHandler{

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public DeleteReviewHandler(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewDto handle(@Valid DeleteReviewCommand command){
        // Finds the review or throws exception
        var review = this.reviewRepository
                .findById(command.getEventId())
                .orElseThrow(() -> new NotFoundReviewException(command.getEventId()));

        // Checks if user owns this review
        if(!review.getUser().getId().equals(command.getUserId()))
            throw new ForbiddenAccessException();
        
        this.reviewRepository.delete(review);
        return reviewMapper.toDTO(review);
    }
}

package com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review;

import com.vivemedellin.valoracion_comentarios.review.exceptions.NotFoundReviewException;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteReviewHandler {

    private final ReviewRepository reviewRepository;

    @Autowired
    public DeleteReviewHandler(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public String handle(DeleteReviewCommand command){
        var review = this.reviewRepository
                .findById(command.getEventId())
                .orElseThrow(() -> new NotFoundReviewException(command.getEventId()));
        this.reviewRepository.delete(review);
        return "Review deleted";
    }
}

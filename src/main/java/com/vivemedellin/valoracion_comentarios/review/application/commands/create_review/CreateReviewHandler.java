package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;
import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateReviewHandler {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public CreateReviewHandler(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Transactional
    public ReviewDTO handle(CreateReviewCommand command) {
        Review review = new Review();
        review.setRating(command.getRating());
        review.setComment(command.getComment());
        review.setEventId(command.getEventId());
        review.setUserId(command.getUserId());
        var saved = reviewRepository.save(review);
        return reviewMapper.toDTO(saved);

    }


}

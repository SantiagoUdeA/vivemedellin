package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.review.exceptions.UserAlreadyReviewedException;
import com.vivemedellin.valoracion_comentarios.review.factory.ReviewFactory;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateReviewHandler {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final ReviewFactory reviewFactory;

    @Autowired
    public CreateReviewHandler(
            ReviewRepository reviewRepository,
            ReviewMapper reviewMapper,
            ReviewFactory reviewFactory
    ) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.reviewFactory = reviewFactory;
    }

    @Transactional
    public ReviewDto handle(@Valid CreateReviewCommand command) {
        // Throws if user has already reviewed
        if (reviewRepository.findByEventIdAndUserId(command.getEventId(), command.getUserId()).isPresent()) {
            throw new UserAlreadyReviewedException();
        }
        var review = reviewFactory.createFromCommand(command);
        var savedReview = reviewRepository.save(review);
        return reviewMapper.toDTO(savedReview);
    }

}

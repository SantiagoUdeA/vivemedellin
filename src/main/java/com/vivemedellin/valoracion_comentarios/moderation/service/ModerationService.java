package com.vivemedellin.valoracion_comentarios.moderation.service;

import com.vivemedellin.valoracion_comentarios.moderation.dto.UpdateReviewModerationDto;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.review.exceptions.NotFoundReviewException;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModerationService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ModerationService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewDto deleteReview(Long reviewId){
        var review = reviewRepository.findById(reviewId).orElseThrow(() -> new NotFoundReviewException(reviewId));
        reviewRepository.delete(review);
        return reviewMapper.toDTO(review);
    }

    public ReviewDto updateReview(UpdateReviewModerationDto updateReviewModerationDto){
        var reviewId = updateReviewModerationDto.getReviewId();
        var review = reviewRepository
                .findById(reviewId)
                .orElseThrow(() -> new NotFoundReviewException(reviewId));
        review.setComment(updateReviewModerationDto.getComment());
        return reviewMapper.toDTO(reviewRepository.save(review));
    }
}

package com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetReviewsByEventIdHandler {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public GetReviewsByEventIdHandler(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDto> handle(@Valid GetReviewsByEventIdQuery query){
        var reviews = reviewRepository.findAllByEventId(query.getEventId());
        return reviews.stream().map(reviewMapper::toDTO).toList();
    }
}

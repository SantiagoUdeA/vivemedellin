package com.vivemedellin.valoracion_comentarios.review.application.queries.get_review_by_user_and_event;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserReviewHandler {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    @Autowired
    public GetUserReviewHandler(ReviewRepository repository, ReviewMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ReviewDto handle(GetUserReviewCommand command){
        var review = this.repository.findByEventIdAndUserId(command.getEventId(), command.getUserId());
        return review.map(mapper::toDTO).orElse(null);
    }
}

package com.vivemedellin.valoracion_comentarios.review.controller;

import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews.GetReviewsByEventIdCommand;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews.GetReviewsByEventIdHandler;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class ReviewController {

    private final CreateReviewHandler createReviewHandler;
    private final GetReviewsByEventIdHandler getReviewsByEventIdHandler;

    @Autowired
    public ReviewController(CreateReviewHandler createReviewHandler, GetReviewsByEventIdHandler getReviewsByEventIdHandler) {
        this.createReviewHandler = createReviewHandler;
        this.getReviewsByEventIdHandler = getReviewsByEventIdHandler;
    }

    @MutationMapping
    public ReviewDTO createReview(@Argument("input") CreateReviewCommand command){
        return this.createReviewHandler.handle(command);
    }

    @QueryMapping
    public List<ReviewDTO> allReviewsByEventId(@Argument int eventId){
        var command = new GetReviewsByEventIdCommand((long) eventId);
        return getReviewsByEventIdHandler.handle(command);
    }

}

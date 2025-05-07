package com.vivemedellin.valoracion_comentarios.review.controller;

import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ReviewController {

    private final CreateReviewHandler createReviewHandler;

    @Autowired
    public ReviewController(CreateReviewHandler createReviewHandler) {
        this.createReviewHandler = createReviewHandler;
    }

    @MutationMapping
    public ReviewDTO createReview(@Argument("input") CreateReviewCommand command){
        return this.createReviewHandler.handle(command);
    }

}

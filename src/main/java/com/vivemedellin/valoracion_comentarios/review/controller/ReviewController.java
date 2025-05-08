package com.vivemedellin.valoracion_comentarios.review.controller;

import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review.DeleteReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review.DeleteReviewHandler;
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
    private final DeleteReviewHandler deleteReviewHandler;

    @Autowired
    public ReviewController(CreateReviewHandler createReviewHandler, GetReviewsByEventIdHandler getReviewsByEventIdHandler, DeleteReviewHandler deleteReviewHandler) {
        this.createReviewHandler = createReviewHandler;
        this.getReviewsByEventIdHandler = getReviewsByEventIdHandler;
        this.deleteReviewHandler = deleteReviewHandler;
    }

    @MutationMapping
    public ReviewDTO createReview(@Argument("input") CreateReviewCommand command){
        return this.createReviewHandler.handle(command);
    }

    @MutationMapping
    public String deleteReview(@Argument int reviewId){
        var command = new DeleteReviewCommand((long) reviewId, "user123");
        return deleteReviewHandler.handle(command);
    }

    @QueryMapping
    public List<ReviewDTO> allReviewsByEventId(@Argument int eventId){
        var command = new GetReviewsByEventIdCommand((long) eventId);
        return getReviewsByEventIdHandler.handle(command);
    }

}

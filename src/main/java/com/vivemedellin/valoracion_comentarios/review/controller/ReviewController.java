package com.vivemedellin.valoracion_comentarios.review.controller;

import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review.DeleteReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review.DeleteReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.commands.update_review.UpdateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.update_review.UpdateReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_review_by_user_and_event.GetUserReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_review_by_user_and_event.GetUserReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews.GetReviewsByEventIdQuery;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews.GetReviewsByEventIdHandler;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.vivemedellin.valoracion_comentarios.shared.util.AuthUtils.getUserId;


@Controller
public class ReviewController {

    private final CreateReviewHandler createReviewHandler;
    private final GetReviewsByEventIdHandler getReviewsByEventIdHandler;
    private final DeleteReviewHandler deleteReviewHandler;
    private final UpdateReviewHandler updateReviewHandler;
    private final GetUserReviewHandler getUserReviewHandler;

    @Autowired
    public ReviewController(CreateReviewHandler createReviewHandler, GetReviewsByEventIdHandler getReviewsByEventIdHandler, DeleteReviewHandler deleteReviewHandler, UpdateReviewHandler updateReviewHandler, GetUserReviewHandler getUserReviewHandler) {
        this.createReviewHandler = createReviewHandler;
        this.getReviewsByEventIdHandler = getReviewsByEventIdHandler;
        this.deleteReviewHandler = deleteReviewHandler;
        this.updateReviewHandler = updateReviewHandler;
        this.getUserReviewHandler = getUserReviewHandler;
    }

    @MutationMapping
    @PreAuthorize("hasRole('user')")
    public ReviewDto createReview(
            @Argument int eventId,
            @Argument int rating,
            @Argument String comment
    ){
        var userId = getUserId();
        var command = new CreateReviewCommand(
                userId,
                (long) eventId,
                rating,
                comment);
        return this.createReviewHandler.handle(command);
    }

    @MutationMapping
    @PreAuthorize("hasRole('user')")
    public ReviewDto deleteReview(@Argument int reviewId){
        var userId = getUserId();
        var command = new DeleteReviewCommand((long) reviewId, userId);
        return deleteReviewHandler.handle(command);
    }

    @MutationMapping
    @PreAuthorize("hasRole('user')")
    public ReviewDto updateReview(
            @Argument int reviewId,
            @Argument int rating,
            @Argument String comment
    ){
        var userId = getUserId();
        var command = new UpdateReviewCommand((long) reviewId, userId, rating, comment);
        return updateReviewHandler.handle(command);
    }

    @QueryMapping
    public List<ReviewDto> allReviewsByEventId(@Argument int eventId){
        var query = new GetReviewsByEventIdQuery((long) eventId);
        return getReviewsByEventIdHandler.handle(query);
    }

    @QueryMapping
    @PreAuthorize("hasRole('user')")
    public ReviewDto reviewByEventId(@Argument("eventId") Integer eventId){
        var userId = getUserId();
        var command = new GetUserReviewCommand((long) eventId, userId);
        return getUserReviewHandler.handle(command);
    }



}

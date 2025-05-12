package com.vivemedellin.valoracion_comentarios.review.controller;

import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review.DeleteReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.delete_review.DeleteReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.commands.update_review.UpdateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.application.commands.update_review.UpdateReviewHandler;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews.GetReviewsByEventIdCommand;
import com.vivemedellin.valoracion_comentarios.review.application.queries.get_reviews.GetReviewsByEventIdHandler;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.shared.exceptions.UnauthorizedAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


@Controller
public class ReviewController {

    private final CreateReviewHandler createReviewHandler;
    private final GetReviewsByEventIdHandler getReviewsByEventIdHandler;
    private final DeleteReviewHandler deleteReviewHandler;
    private final UpdateReviewHandler updateReviewHandler;

    @Autowired
    public ReviewController(CreateReviewHandler createReviewHandler, GetReviewsByEventIdHandler getReviewsByEventIdHandler, DeleteReviewHandler deleteReviewHandler, UpdateReviewHandler updateReviewHandler) {
        this.createReviewHandler = createReviewHandler;
        this.getReviewsByEventIdHandler = getReviewsByEventIdHandler;
        this.deleteReviewHandler = deleteReviewHandler;
        this.updateReviewHandler = updateReviewHandler;
    }

    @MutationMapping
    public ReviewDto createReview(
            @Argument int eventId,
            @Argument int rating,
            @Argument String comment
    ){
        Authentication auth = getAuthentication();
        var userId = UUID.fromString((String) auth.getPrincipal());
        var command = new CreateReviewCommand(
                userId,
                (long) eventId,
                rating,
                comment);
        return this.createReviewHandler.handle(command);
    }

    @MutationMapping
    public ReviewDto deleteReview(@Argument int reviewId){
        Authentication auth = getAuthentication();
        String userId = (String) auth.getPrincipal(); // El sub de Supabase
        var command = new DeleteReviewCommand((long) reviewId, UUID.fromString(userId));
        return deleteReviewHandler.handle(command);
    }

    @MutationMapping
    public ReviewDto updateReview(
            @Argument int reviewId,
            @Argument int rating,
            @Argument String comment
    ){
        Authentication auth = getAuthentication();
        UUID userId = UUID.fromString((String) auth.getPrincipal());
        var command = new UpdateReviewCommand((long) reviewId, userId, rating, comment);
        return updateReviewHandler.handle(command);
    }

    @QueryMapping
    public List<ReviewDto> allReviewsByEventId(@Argument int eventId){
        var command = new GetReviewsByEventIdCommand((long) eventId);
        return getReviewsByEventIdHandler.handle(command);
    }

    private Authentication getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new UnauthorizedAccessException();
        }
        return auth;
    }

}

package com.vivemedellin.valoracion_comentarios.review.factory;

import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import com.vivemedellin.valoracion_comentarios.review.application.commands.create_review.CreateReviewCommand;
import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import com.vivemedellin.valoracion_comentarios.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewFactory {

    public Review createFromCommand(CreateReviewCommand command){
        var reviewBuilder = Review.builder();
        var user = new User();
        var event = new Event();

        user.setId(command.getUserId());
        event.setId(command.getEventId());

        reviewBuilder.rating(command.getRating());
        reviewBuilder.comment(command.getComment());
        reviewBuilder.event(event);
        reviewBuilder.user(user);

        return reviewBuilder.build();
    }
}

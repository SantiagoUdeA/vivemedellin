package com.vivemedellin.valoracion_comentarios.review.exceptions;

public class UserAlreadyReviewedException extends RuntimeException{

    public UserAlreadyReviewedException() {
        super("User has already reviewed this event");
    }
}

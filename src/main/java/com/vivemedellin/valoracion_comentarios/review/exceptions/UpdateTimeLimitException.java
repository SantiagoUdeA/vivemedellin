package com.vivemedellin.valoracion_comentarios.review.exceptions;

public class UpdateTimeLimitException extends RuntimeException{

    public UpdateTimeLimitException() {
        super("You can't update the review after 24 hours");
    }
}

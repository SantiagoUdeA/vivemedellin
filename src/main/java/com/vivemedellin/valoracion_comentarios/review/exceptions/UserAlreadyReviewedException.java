package com.vivemedellin.valoracion_comentarios.review.exceptions;

import com.vivemedellin.valoracion_comentarios.shared.exceptions.BadRequestException;

public class UserAlreadyReviewedException extends BadRequestException {

    public UserAlreadyReviewedException() {
        super("User has already reviewed this event");
    }
}

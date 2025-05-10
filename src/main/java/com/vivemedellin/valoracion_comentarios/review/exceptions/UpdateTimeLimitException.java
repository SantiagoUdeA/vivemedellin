package com.vivemedellin.valoracion_comentarios.review.exceptions;

import com.vivemedellin.valoracion_comentarios.shared.exceptions.BadRequestException;

public class UpdateTimeLimitException extends BadRequestException {

    public UpdateTimeLimitException() {
        super("You can't update the review after 24 hours");
    }
}

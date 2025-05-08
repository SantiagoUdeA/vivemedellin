package com.vivemedellin.valoracion_comentarios.review.exceptions;

import com.vivemedellin.valoracion_comentarios.shared.exceptions.NotFoundException;

public class NotFoundReviewException extends NotFoundException {

    public NotFoundReviewException(Long reviewId){
        super("Review with id " + reviewId.toString() + " was not found.");
    }
}

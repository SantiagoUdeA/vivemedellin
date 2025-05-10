package com.vivemedellin.valoracion_comentarios.shared.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}

package com.vivemedellin.valoracion_comentarios.shared.exceptions;

public class ForbiddenAccessException extends RuntimeException{

    public ForbiddenAccessException(){
        super("You don't have permission to access this resource");
    }
}

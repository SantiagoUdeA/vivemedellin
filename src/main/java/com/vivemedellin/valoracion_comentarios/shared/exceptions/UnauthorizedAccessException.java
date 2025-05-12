package com.vivemedellin.valoracion_comentarios.shared.exceptions;

public class UnauthorizedAccessException extends RuntimeException{

    public UnauthorizedAccessException(){
        super("Invalid or expired token");
    }
}

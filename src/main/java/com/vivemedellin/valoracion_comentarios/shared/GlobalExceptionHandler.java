package com.vivemedellin.valoracion_comentarios.shared;

import com.vivemedellin.valoracion_comentarios.shared.exceptions.BadRequestException;
import com.vivemedellin.valoracion_comentarios.shared.exceptions.ForbiddenAccessException;
import com.vivemedellin.valoracion_comentarios.shared.exceptions.NotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import graphql.schema.DataFetchingEnvironment;

import java.util.Arrays;


@Component
@ControllerAdvice
public class GlobalExceptionHandler extends DataFetcherExceptionResolverAdapter {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected GraphQLError resolveToSingleError(@NonNull Throwable ex, @NonNull DataFetchingEnvironment env) {

        String message = "Internal server error";

        if (
                ex instanceof NotFoundException ||
                ex instanceof BadRequestException ||
                ex instanceof ForbiddenAccessException
        ){
            message = ex.getMessage();
        }else if(ex instanceof  AccessDeniedException){
            message = "You don't have permission to access this resource";
        }else if(ex instanceof AuthenticationException){
            message = "Invalid or expired token";
        } else{
            logger.error(ex.getMessage());
            logger.error(Arrays.toString(ex.getStackTrace()));
        }

        return GraphqlErrorBuilder.newError(env)
                .message(message)
                .build();
    }
}

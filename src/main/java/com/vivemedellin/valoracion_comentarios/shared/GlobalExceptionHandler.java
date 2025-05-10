package com.vivemedellin.valoracion_comentarios.shared;

import com.vivemedellin.valoracion_comentarios.shared.exceptions.BadRequestException;
import com.vivemedellin.valoracion_comentarios.shared.exceptions.NotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.validation.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    protected GraphQLError resolveToSingleError(Throwable ex,  DataFetchingEnvironment env) {

        String message = "Internal server error";

        if (ex instanceof NotFoundException || ex instanceof BadRequestException){
            message = ex.getMessage();
        }else{
            logger.error(ex.getMessage());
            logger.error(Arrays.toString(ex.getStackTrace()));
        }

        return GraphqlErrorBuilder.newError(env)
                .message(message)
                .errorType(graphql.ErrorType.DataFetchingException)
                .build();
    }
}

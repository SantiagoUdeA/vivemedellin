package com.vivemedellin.valoracion_comentarios.shared;

import com.vivemedellin.valoracion_comentarios.shared.exceptions.NotFoundException;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.stereotype.Component;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import graphql.schema.DataFetchingEnvironment;

@Component
@ControllerAdvice
public class GlobalExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex,  DataFetchingEnvironment env) {

        return GraphqlErrorBuilder.newError(env)
                .message("Error: " + ex.getMessage())
                .errorType(graphql.ErrorType.DataFetchingException)
                .build();
    }
}

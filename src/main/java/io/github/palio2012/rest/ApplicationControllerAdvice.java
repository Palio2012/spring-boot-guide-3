package io.github.palio2012.rest;

import io.github.palio2012.exceptions.RegraNegocioException;
import io.github.palio2012.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler (RegraNegocioException.class)
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException (RegraNegocioException ex) {
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }

}

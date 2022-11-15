package io.github.palio2012.rest;

import io.github.palio2012.exceptions.PedidoNaoEncontradoException;
import io.github.palio2012.exceptions.RegraNegocioException;
import io.github.palio2012.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler (RegraNegocioException.class)
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException (RegraNegocioException ex) {
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ApiErrors handlePedidoNotFoundException (PedidoNaoEncontradoException ex) {
        return new ApiErrors (ex.getMessage());
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException (MethodArgumentNotValidException e) {
        List<String> errors =
        e.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        return new ApiErrors(errors);
    }
}

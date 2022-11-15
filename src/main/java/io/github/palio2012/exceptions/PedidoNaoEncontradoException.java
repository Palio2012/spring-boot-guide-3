package io.github.palio2012.exceptions;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException () {
        super("Pedido não encontrado");
    }
}

package com.algaworks.algafood.domain.exception;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long SerialVersionUID = 1L;

    public PedidoNaoEncontradoException(String codigoPedido){
        super(String.format("Não existe pedido com código %s", codigoPedido));
    }
}

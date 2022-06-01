package com.algaworks.algafood.domain.exception;

public class PedidoNaoEncontradoException extends NegocioException {

    private static final long SerialVersionUID = 1L;

    public PedidoNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public PedidoNaoEncontradoException(Long pedidoId){
        this(String.format("Não existe pedido com código %d", pedidoId));
    }
}

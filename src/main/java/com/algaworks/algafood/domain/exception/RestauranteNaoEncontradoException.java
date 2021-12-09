package com.algaworks.algafood.domain.exception;

public abstract class RestauranteNaoEncontradoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public RestauranteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

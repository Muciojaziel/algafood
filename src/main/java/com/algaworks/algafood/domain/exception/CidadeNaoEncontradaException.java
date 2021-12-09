package com.algaworks.algafood.domain.exception;

public abstract class CidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public CidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}

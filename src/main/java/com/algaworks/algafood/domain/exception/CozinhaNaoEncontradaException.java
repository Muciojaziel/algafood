package com.algaworks.algafood.domain.exception;

public abstract class CozinhaNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public CozinhaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}

package com.algaworks.algafood.domain.exception;

public class RestauranteNaoEncontradoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public RestauranteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public RestauranteNaoEncontradoException(Long restauranteId) {
        this(String.format("Não existe cadastro de Restaurante com código %d", restauranteId));
    }
}

package com.algaworks.algafood.domain.exception;

public class ProdutoNaoEncontradoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontradoException(Long restauranteId, Long produtoId) {
        this(String.format("Não existe cadastro de Produto com código %d  para o restaurante de código %d",
                produtoId, restauranteId));
    }
}

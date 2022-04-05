package com.algaworks.algafood.domain.exception;

public class UsuarioNaoEncontradoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public UsuarioNaoEncontradoException(Long usuarioId) {
        this(String.format("Não existe cadastro de Usuário com código %d", usuarioId));
    }
}

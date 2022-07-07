package com.algaworks.algafood.api.model;

import com.algaworks.algafood.domain.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FotoProdutoModel {

    private String nomeArquivo;
    private String descricao;
    private String contenttype;
    private Long tamanho;
}

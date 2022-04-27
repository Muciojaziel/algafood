package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.api.model.ProdutoModel;
import com.algaworks.algafood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel salvar(){
        return null;
    }



}

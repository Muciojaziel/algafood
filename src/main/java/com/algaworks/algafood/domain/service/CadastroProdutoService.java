package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

//    public Produto salvar(){
//        return null;
//    }
//
//    public Produto buscarOuFalhar(Long produtoId){
//
//    }


}

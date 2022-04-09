package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.FormaPagamentoAssembler;
import com.algaworks.algafood.api.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/formapagamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormaPagamentoController {

    @Autowired
    FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    FormaPagamentoAssembler formaPagamentoAssembler;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<FormaPagamentoModel> listar() { return formaPagamentoAssembler.toCollectionModel(formaPagamentoRepository.findAll()); }

}
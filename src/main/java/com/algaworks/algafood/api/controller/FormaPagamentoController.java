package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.FormaPagamentoAssembler;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.domain.exception.FormaPagamentoNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/formapagamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private FormaPagamentoAssembler formaPagamentoAssembler;

    @Autowired
    private CadastroFormaPagamentoService formaPagamentoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public List<FormaPagamentoModel> listar() { return formaPagamentoAssembler.toCollectionModel(formaPagamentoRepository.findAll()); }


    @GetMapping("/{formaPagamentoId}")
    public FormaPagamentoModel buscar(@PathVariable Long formaPagamentoId) {
      return formaPagamentoAssembler.toModel(formaPagamentoService.buscarOuFalhar(formaPagamentoId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamentoModel adicionar(@RequestBody @Valid FormaPagamento formaPagamento){
        try{
            return  formaPagamentoAssembler.toModel(formaPagamentoService.salvar(formaPagamento));

        } catch (FormaPagamentoNaoEncontradaException e) {
           throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{formaPagamentoId}")
    @ResponseStatus
    public FormaPagamentoModel atualizar(@PathVariable Long formaPagamentoId, @RequestBody @Valid FormaPagamento formaPagamento){
        try {
            FormaPagamento formaPagamentoAtual = formaPagamentoService.buscarOuFalhar(formaPagamentoId);
            copyToModel( formaPagamentoAtual, formaPagamento);

            return formaPagamentoAssembler.toModel(formaPagamentoService.salvar(formaPagamentoAtual));

        } catch (FormaPagamentoNaoEncontradaException e){
            throw new NegocioException(e.getMessage());
        }
    }

    private void copyToModel(FormaPagamento formaPagamento, FormaPagamento formaPagamentoAtual) {
        modelMapper.map( formaPagamentoAtual, formaPagamento);
    }

}
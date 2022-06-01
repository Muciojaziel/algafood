package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.PedidoModelAssembler;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.domain.repository.PedidoRepository;
import com.algaworks.algafood.domain.service.EmissaoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @Autowired
    private EmissaoPedidoService emissaoPedidoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoModel> listar(){
        return pedidoModelAssembler.toCollectionModel(pedidoRepository.findAll());
    }

    @GetMapping("/{pedidoId}")
    @ResponseStatus(HttpStatus.OK)
    public PedidoModel buscar(@PathVariable Long pedidoId){
        return pedidoModelAssembler.toModel(emissaoPedidoService.buscarOuFalhar(pedidoId));
    }

}

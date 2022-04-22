package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.UsuarioModelAssembler;
import com.algaworks.algafood.api.assembler.input.UsuarioInputDissambler;
import com.algaworks.algafood.api.model.UsuarioModel;
import com.algaworks.algafood.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private UsuarioInputDissambler usuarioInputDissambler;

    @GetMapping
    public List<UsuarioModel> listar(){ return usuarioModelAssembler.toCollectionModel(usuarioRepository.findAll()); }


}

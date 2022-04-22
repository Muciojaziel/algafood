package com.algaworks.algafood.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioModel {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

}

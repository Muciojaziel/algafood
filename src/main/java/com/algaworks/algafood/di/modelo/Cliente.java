package com.algaworks.algafood.di.modelo;

public class Cliente {
	public Cliente(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	private String nome;
	private String email;
	private String telefone;
	private boolean ativo = false;
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void ativar() {
		this.ativo = true;
	}

}

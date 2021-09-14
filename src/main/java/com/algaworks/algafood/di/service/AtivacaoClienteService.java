package com.algaworks.algafood.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	@Qualifier("urgente")
	@Autowired
	private Notificador notificador;
	
	//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}

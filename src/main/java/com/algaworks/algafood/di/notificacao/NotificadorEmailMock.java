package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmailMock implements Notificador {
	
	public NotificadorEmailMock() {
		System.out.println("Notificador de email Mock");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Mock: Notificação seria enviada para %s através do email %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
	
}

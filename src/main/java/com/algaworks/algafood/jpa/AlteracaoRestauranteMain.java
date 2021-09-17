package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.Repository.RestauranteRepository;
import com.algaworks.algafood.domain.model.Restaurante;

public class AlteracaoRestauranteMain {
	public static void main(String[] args) {

	ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
			.web(WebApplicationType.NONE)
			.run(args);
	
	RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
	
	Restaurante restaurante1 = new Restaurante();
	restaurante1.setId(1L);
	restaurante1.setNome("RestRant");
	restaurante1.setTaxaFrete(new BigDecimal(10.0));
	
	restaurantes.salvar(restaurante1);
	
	
	}
}

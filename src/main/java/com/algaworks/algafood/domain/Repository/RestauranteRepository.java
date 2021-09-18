package com.algaworks.algafood.domain.Repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {
	
	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);
	
}
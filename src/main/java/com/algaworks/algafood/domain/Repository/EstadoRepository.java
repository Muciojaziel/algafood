package com.algaworks.algafood.domain.Repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Estado estado);
	
}

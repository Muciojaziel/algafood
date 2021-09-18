package com.algaworks.algafood.infrastructure.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.Repository.CidadeRepository;
import com.algaworks.algafood.domain.model.Cidade;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Override
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Override
	public void remover(Cidade cidade) {
		cidade = buscar(cidade.getId());
		manager.remove(cidade);
	}
}

package com.algaworks.algafood.infrastructure.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.model.Cidade;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade buscar(Long id) {return manager.find(Cidade.class, id);}

	@Transactional
	@Override
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		Cidade cidade = buscar(id);

		if(cidade == null){
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cidade);
	}
}

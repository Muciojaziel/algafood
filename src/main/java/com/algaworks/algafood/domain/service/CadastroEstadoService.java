package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.Repository.CidadeRepository;
import com.algaworks.algafood.domain.Repository.EstadoRepository;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadosRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public Estado salvar(Estado estado){ return estadosRepository.salvar(estado);}

    public void excluir(Long estadoId) {
        try {
            estadosRepository.remover(estadoId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de estado com código %d", estadoId));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
        }
    }

}

package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    public static final String MSG_ESTADO_EM_USO = "Estado de código %d não pode ser removido, pois está em uso";
    @Autowired
    private EstadoRepository estadosRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public Estado salvar(Estado estado) {
        return estadosRepository.save(estado);
    }

    public void excluir(Long estadoId) {
        try {
            estadosRepository.deleteById(estadoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EstadoNaoEncontradoException(estadoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ESTADO_EM_USO, estadoId));
        }
    }

    public Estado buscarOuFalhar(Long estadoId) {
        return estadosRepository.findById(estadoId)
                .orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
    }

}

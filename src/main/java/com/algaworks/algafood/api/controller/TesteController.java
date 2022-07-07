package com.algaworks.algafood.api.controller;



import com.algaworks.algafood.api.assembler.FormaPagamentoModelAssembler;
import com.algaworks.algafood.api.assembler.input.FormaPagamentoInputDisassembler;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;
import com.algaworks.algafood.domain.exception.FormaPagamentoNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
public class TesteController {

   @GetMapping()
    public List<Object[]> listar() {
//       Map<String, Integer> valorF = new HashMap<>();
//       FormaPagamentoModel fpmTeste = new FormaPagamentoModel();
//       fpmTeste.setDescricao("testespaga");
//       fpmTeste.setId(6L);
//       valorF.put(fpmTeste.getDescricao(), 10);

//       FormaPagamentoModel fpmTeste2 = new FormaPagamentoModel();
//       fpmTeste.setDescricao("testespaga");
//       fpmTeste.setId(7L);
//       valorF.put(fpmTeste2.getDescricao(), 15);
//        Object[] opa = null;
//        opa.
//       List<Object[]> teste = new LinkedList<>();
//       teste.add("avd", );
//
//        List<Map<String, Integer>> fpm = new ArrayList<>();
//        fpm.add(valorF);
       return  null;
   }


}

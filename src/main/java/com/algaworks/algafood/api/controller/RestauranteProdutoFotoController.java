package com.algaworks.algafood.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping
public class RestauranteProdutoFotoController {

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void atualizarFoto(@PathVariable Long restauranteId, @PathVariable Long produtoId,
                              @RequestBody MultipartFile arquivo){

        var nomeArquivo = UUID.randomUUID().toString()
        + "_" + arquivo.getOriginalFilename();

        var arquivoFoto = Path.of("caminho", nomeArquivo);

        System.out.println(arquivoFoto);
        System.out.println(arquivo.getContentType());

        try {
            arquivo.transferTo(arquivoFoto);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}

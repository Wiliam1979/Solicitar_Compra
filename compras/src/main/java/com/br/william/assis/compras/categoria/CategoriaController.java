package com.br.william.assis.compras.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;


    @PostMapping
    @Transactional
   public ResponseEntity<?>criar(@RequestBody @Valid NovaCategoriaRequest request, UriComponentsBuilder uriComponentsBuilder){

        Categoria  categoria = request.toModelCategoria();

        categoriaRepository.save(categoria);

        URI uri = uriComponentsBuilder.path("/api/categoria/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();



   }
}

package com.br.william.assis.compras.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.beans.Transient;

@RestController
@RequestMapping(value = "/api/categoria/{id}")
public class AtualizarCategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

      @PutMapping
      @Transactional
    public ResponseEntity<?>atualizarCategoria(@PathVariable Long id, @RequestBody @Valid AtualicazarCategoriaRequest request){

         Categoria categoria = request.toModelAtualizarCategoria(id,categoriaRepository );

         categoriaRepository.save(categoria);

         return ResponseEntity.ok().build();

    }
}


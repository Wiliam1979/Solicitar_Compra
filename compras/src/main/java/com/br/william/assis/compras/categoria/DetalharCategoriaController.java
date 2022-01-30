package com.br.william.assis.compras.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api/categoria/{id}")
public class DetalharCategoriaController {

    @Autowired
    CategoriaRepository repository;

     @GetMapping
   public ResponseEntity<?> buscar(@PathVariable ("id")Long id) {


         Optional<Categoria> categoria = repository.findById(id);

         if (categoria.isPresent()) {

             return ResponseEntity.ok(new NovaCategoriaResponse(categoria.get()));
         }

          return ResponseEntity.notFound().build();
     }

}

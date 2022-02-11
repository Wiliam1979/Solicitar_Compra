package com.br.william.assis.compras.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/categoria/{id}")
public class DeletarCategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @DeleteMapping
    @Transactional
    public ResponseEntity<?>removerCategoria(@PathVariable Long id){

        categoriaRepository.deleteById(id);

        return ResponseEntity.ok().build();

    }
}

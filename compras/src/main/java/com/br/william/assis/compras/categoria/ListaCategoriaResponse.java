package com.br.william.assis.compras.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListaCategoriaResponse {

    private Long id;

    private String nome;

    public ListaCategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public static List<ListaCategoriaResponse> toModel(List<Categoria> categoriaList) {
        return categoriaList.stream().map(ListaCategoriaResponse::new).collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @RestController
    @RequestMapping(value = "/api/categoria/{id}")
    public static class DetalharCategoriaController {

        @Autowired
        CategoriaRepository repository;

         @GetMapping
       public ResponseEntity<?> buscar(@PathVariable("id")Long id) {


             Optional<Categoria> categoria = repository.findById(id);

             if (categoria.isPresent()) {

                 return ResponseEntity.ok(new NovaCategoriaResponse(categoria.get()));
             }

              return ResponseEntity.notFound().build();
         }

    }
}

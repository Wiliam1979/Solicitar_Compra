package com.br.william.assis.compras.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categorias")
public class ListaCategoriaController {

     @Autowired
     CategoriaRepository categoriaRepository;

      @GetMapping
     public List<ListaCategoriaResponse> listar(){
          List<Categoria>categoriaList = categoriaRepository.findAll();
          return ListaCategoriaResponse.toModel(categoriaList);

     }

}

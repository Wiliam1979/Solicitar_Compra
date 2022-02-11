package com.br.william.assis.compras.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/produto/{id}")
public class DetalharProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<?> buscar(@PathVariable Long id){

       Optional< Produto> produto = produtoRepository.findById(id);

        if(produto.isPresent()){
            return ResponseEntity.ok(new DetalharProdutoResponse(produto.get()));
        }

      return ResponseEntity.notFound().build();


    }
}

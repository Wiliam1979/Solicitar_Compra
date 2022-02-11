package com.br.william.assis.compras.produto;

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
@RequestMapping(value = "/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?>criaProduto(@RequestBody @Valid NovoProdutoRequest request, UriComponentsBuilder uriComponentsBuilder){

        Produto produto = request.toModel();

         produtoRepository.save(produto);

        URI uri =uriComponentsBuilder.path("/api/produto/{id}").buildAndExpand(produto.getId()).toUri();

         return ResponseEntity.created(uri).build();



    }
}

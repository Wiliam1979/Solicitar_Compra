package com.br.william.assis.compras.produto;

import com.br.william.assis.compras.categoria.Categoria;
import com.br.william.assis.compras.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produto/{produtoid}/categoria")
public class ProdutoCategoriaController {




    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(@PathVariable Long produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);
        return ResponseEntity.ok(produto.get().getCategorias());
    }

    @Transactional
    @PutMapping("/{categoriaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long produtoId, @PathVariable Long categoriaId) {


        Produto produto = produtoRepository.getOne(produtoId);
        Categoria categoria= categoriaRepository.getOne(categoriaId);

        produto.adicionarCategoria(categoria);






    }

  /*  @DeleteMapping("/{categoriaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long produtoId, @PathVariable Long categoriaId)
    {
        produtoService.desassociarCategoria(produtoId, categoriaId);
    } */

}

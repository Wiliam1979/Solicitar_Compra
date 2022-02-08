package com.br.william.assis.compras.produto;

import com.br.william.assis.compras.categoria.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produto/{produtoId}/categoria")
public class ProdutoCategoriaController {

    @Autowired
   private ProdutoService produtoService;

    @GetMapping
 public ResponseEntity<List<Categoria>>listar(@PathVariable Long produtoId){
  Produto produto =produtoService.buscar(produtoId);
  return ResponseEntity.ok((produto.getCategorias()));
 }

    @PutMapping("/{categoriaId}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
  public void associar(@PathVariable Long produtoId, @PathVariable Long categoriaId){
  produtoService.associarCategoria(produtoId, categoriaId);
 }

    @DeleteMapping("/{categoriaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long produtoId, @PathVariable Long categoriaId)
    {
        produtoService.desassociarCategoria(produtoId, categoriaId);
    }



          }





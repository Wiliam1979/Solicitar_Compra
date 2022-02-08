package com.br.william.assis.compras.produto;

import com.br.william.assis.compras.categoria.Categoria;
import com.br.william.assis.compras.categoria.CategoriaRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Optional;

public class NovoProdutoRequest {

    private Long id;

    @NotBlank
    private String nome;

    private Long idCategoria;

    @Min(0)
    private BigDecimal preco;

    public NovoProdutoRequest( String nome, BigDecimal preco) {

        this.nome = nome;
        this.preco = preco;
    }

    public Produto toModel() {


        return new Produto(this.nome, this.preco);
    }
}

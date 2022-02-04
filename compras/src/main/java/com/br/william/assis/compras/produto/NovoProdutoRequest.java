package com.br.william.assis.compras.produto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class NovoProdutoRequest {

    private Long id;

    @NotBlank
    private String nome;

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

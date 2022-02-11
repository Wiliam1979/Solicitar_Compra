package com.br.william.assis.compras.produto;

import java.math.BigDecimal;

public class DetalharProdutoResponse {

    private Long id;

    private String nome;

    private BigDecimal preco;

    public DetalharProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}

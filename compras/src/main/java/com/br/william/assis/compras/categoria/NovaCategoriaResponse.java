package com.br.william.assis.compras.categoria;

public class NovaCategoriaResponse {

    private Long id;

    private String nome;

    public NovaCategoriaResponse(Categoria categoria) {
        id = categoria.getId();
        nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

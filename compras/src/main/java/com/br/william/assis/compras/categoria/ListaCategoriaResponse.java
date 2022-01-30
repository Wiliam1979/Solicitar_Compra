package com.br.william.assis.compras.categoria;

import java.util.List;
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
}

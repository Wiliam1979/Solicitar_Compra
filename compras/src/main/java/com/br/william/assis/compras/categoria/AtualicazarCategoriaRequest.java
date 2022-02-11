package com.br.william.assis.compras.categoria;

public class AtualicazarCategoriaRequest {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModelAtualizarCategoria(Long id, CategoriaRepository categoriaRepository) {

        Categoria categoria = categoriaRepository.getById(id);

        categoria.setNome(this.nome);

        return categoria;


    }
}

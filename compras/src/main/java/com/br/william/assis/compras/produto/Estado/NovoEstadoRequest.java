package com.br.william.assis.compras.produto.Estado;


import javax.validation.constraints.NotBlank;

public class NovoEstadoRequest {

    @NotBlank
    private  String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Estado toModel() {
        return new Estado(this.nome);
    }
}

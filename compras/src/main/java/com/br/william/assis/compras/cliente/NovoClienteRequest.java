package com.br.william.assis.compras.cliente;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoClienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String cpfOuCnpj;

    @NotNull
    private Integer tipo;

    public NovoClienteRequest(String nome, String email, String cpfOuCnpj, Integer tipo) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
    }

    public Cliente toModel() {
        return new Cliente(this.nome, this.email, this.cpfOuCnpj,TipoCliente.toEnum(tipo));
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public Integer getTipo() {
        return tipo;
    }
}

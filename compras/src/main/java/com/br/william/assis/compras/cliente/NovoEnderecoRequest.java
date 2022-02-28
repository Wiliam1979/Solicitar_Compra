package com.br.william.assis.compras.cliente;

import com.br.william.assis.compras.cidade.Cidade;
import com.br.william.assis.compras.cidade.CidadeRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoEnderecoRequest {

    @NotBlank
    private String lougradouro;

    @NotBlank
    private String numero;


    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cep;


    @NotNull
    private Long cidade;

    public NovoEnderecoRequest() {
    }

    public NovoEnderecoRequest(String lougradouro, String numero, String complemento, String bairro, String cep, Long cidade) {
        this.lougradouro = lougradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }




    public Endereco toModel( CidadeRepository cidadeRepository) {
        Cidade cidadeId = cidadeRepository
                .findById(this.cidade)
                .orElseThrow(() -> new RuntimeException("Cidade não Encontrada"));
        return new Endereco(this.lougradouro, this.numero, this.complemento, this.bairro, this.cep, cidadeId);
    }

    public Endereco toModelEnd() {

        return new Endereco(this.lougradouro, this.numero, this.complemento, this.bairro, this.cep);
    }

    public String getLougradouro() {
        return lougradouro;
    }

    public void setLougradouro(String lougradouro) {
        this.lougradouro = lougradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getCidade() {
        return cidade;
    }

    public void setCidade(Long cidade) {
        this.cidade = cidade;
    }
}

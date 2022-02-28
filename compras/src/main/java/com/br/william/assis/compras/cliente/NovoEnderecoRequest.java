package com.br.william.assis.compras.cliente;

import com.br.william.assis.compras.cidade.Cidade;
import com.br.william.assis.compras.cidade.CidadeRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private Long cliente;
     @NotNull
    private Long cidade;

    public NovoEnderecoRequest(String lougradouro, String numero, String complemento, String bairro, String cep, Long cliente, Long cidade) {
        this.lougradouro = lougradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade = cidade;
    }

    public Endereco toModel(ClienteRepository clienteRepository, CidadeRepository cidadeRepository) {

        Cliente clienteId = clienteRepository
                .findById(cliente).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        Cidade cidadeId = cidadeRepository
                .findById(cidade).orElseThrow(()->new RuntimeException("Cidade não encontrada"));


        return new Endereco(this.lougradouro, this.numero, this.complemento, this.bairro, this.cep,clienteId, cidadeId);
    }
}

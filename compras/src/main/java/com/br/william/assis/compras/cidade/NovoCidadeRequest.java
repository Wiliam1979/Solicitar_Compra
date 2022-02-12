package com.br.william.assis.compras.cidade;

import com.br.william.assis.compras.Estado.Estado;
import com.br.william.assis.compras.Estado.EstadoRepository;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoCidadeRequest {

    @NotNull
    private Long estado;

    @NotBlank
    private String nome;

    public NovoCidadeRequest(Long estado, String nome) {
        this.estado = estado;
        this.nome = nome;
    }


    public Cidade toModel(EstadoRepository estadoRepository) {

        Estado estadoId = estadoRepository
                .findById(this.estado)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        return new Cidade(this.nome, estadoId);
    }
}

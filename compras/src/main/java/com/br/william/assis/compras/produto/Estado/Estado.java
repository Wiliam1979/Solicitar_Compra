package com.br.william.assis.compras.produto.Estado;

import com.br.william.assis.compras.cidade.Cidade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
    private String nome;

     @OneToMany(mappedBy = "estado")
     private List<Cidade> cidades = new ArrayList<>();

    public Estado(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Estado(){

    }

    public Long getId() {
        return id;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

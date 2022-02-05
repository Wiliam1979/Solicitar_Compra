package com.br.william.assis.compras.categoria;

import com.br.william.assis.compras.produto.Produto;

import javax.persistence.*;
;import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
    private String nome;

     @ManyToMany(mappedBy = "categorias")
     private List<Produto> produtos = new ArrayList<>();


    public Categoria(String nome) {
        this.nome = nome;
    }

      @Deprecated
    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}

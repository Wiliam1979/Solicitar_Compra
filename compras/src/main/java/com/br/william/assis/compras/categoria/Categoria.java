package com.br.william.assis.compras.categoria;



import javax.persistence.*;


@Entity
public class Categoria {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
    private String nome;


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


}

package com.br.william.assis.compras.cliente;

import com.br.william.assis.compras.cidade.Cidade;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lougradouro;

     @Column(nullable = false)
    private String numero;


     private String complemento;

     @Column(nullable = false)
     private String bairro;

     @Column(nullable = false)
     private String cep;


     @ManyToOne
     @JoinColumn(name = "cliente_id")
     private Cliente cliente;

     @ManyToOne
     @JoinColumn(name = "cidade_id")
     private Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Deprecated
    public Endereco() {
    }

    public Endereco(String lougradouro, String numero, String complemento, String bairro, String cep, Cliente cliente, Cidade cidade) {
        this.lougradouro = lougradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade =cidade;
    }

    public Long getId() {
        return id;
    }

    public String getLougradouro() {
        return lougradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}

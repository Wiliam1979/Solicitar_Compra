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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

package com.br.william.assis.compras.cliente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

     @Column(nullable = false)
    private String cpfOuCnpj;

     private Integer tipo;

      @OneToMany(mappedBy = "cliente")
     private List<Endereco> enderecos = new ArrayList<>();

       @ElementCollection
       @CollectionTable(name = "TELEFONE")
      private Set<String> telefones = new HashSet<>();

      @Deprecated
    public Cliente() {
    }

    public Cliente(String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCod();
    }

    public Long getId() {
        return id;
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

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(tipo);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }
}

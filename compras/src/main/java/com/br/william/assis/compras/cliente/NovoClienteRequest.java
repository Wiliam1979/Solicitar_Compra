package com.br.william.assis.compras.cliente;


import com.br.william.assis.compras.cidade.Cidade;
import com.br.william.assis.compras.cidade.CidadeRepository;

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


    private String lougradouro;


    private String numero;


    private String complemento;


    private String bairro;


    private String cep;

     private  Long cliente;

    private Long cidade;

    private String telefone1;

    private String telefone2;

    private String telefone3;




    public NovoClienteRequest() {
    }

    public NovoClienteRequest(String nome, String email, String cpfOuCnpj, Integer tipo, String lougradouro, String numero, String complemento, String bairro, String cep, Long cidade, Long cliente, Long cliente1, String telefone1, String telefone2, String telefone3) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
        this.lougradouro = lougradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cliente = cliente;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
    }

    public Cliente toModel( CidadeRepository cidadeRepository) {

        Cliente  cliente= new Cliente(this.nome, this.email, this.cpfOuCnpj,TipoCliente.toEnum(tipo));


        Cidade cidadeId = cidadeRepository.findById(cidade).get();

        cliente.getTelefones().add(telefone1);

        if(getTelefone2()!=null){
            cliente.getTelefones().add(telefone2);
        }
        if (getTelefone3()!= null){
            cliente.getTelefones().add(telefone3);
        }
        

        Endereco endereco = new Endereco(this.lougradouro, this.numero, this.complemento, this.bairro, this.cep,cliente, cidadeId);

         cliente.AdicionarEndereco(endereco);
        return cliente;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public String getTelefone3() {
        return telefone3;
    }
}

package com.br.william.assis.compras.cliente;




import com.br.william.assis.compras.cidade.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class NovoClienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String cpfOuCnpj;

    @NotNull
    private Integer tipo;


    private List<Long> enderecos;

    private String telefone1;

    private String telefone2;





    public NovoClienteRequest(String nome, String email, String cpfOuCnpj, Integer tipo, List<Long> enderecos) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
        this.enderecos= enderecos;

        

    }

    public Cliente toModel(EnderecoRepository enderecoRepository) {

        Cliente  cliente= new Cliente(this.nome, this.email, this.cpfOuCnpj,TipoCliente.toEnum(tipo));

        this.enderecos.forEach(item ->{
            Endereco endereco = enderecoRepository.findById(item).get();

            cliente.AdicionarEndereco(endereco);

        });
   return cliente;

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

    public Integer getTipo() {
        return tipo;
    }
}

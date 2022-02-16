package com.br.william.assis.compras.cliente;

import com.br.william.assis.compras.cidade.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

     @Autowired
     private EnderecoRepository enderecoRepository;

     @Autowired
     ClienteRepository clienteRepository;

     @Autowired
     private CidadeRepository cidadeRepository;



     @PostMapping
     @Transactional
    public ResponseEntity<?>criarEndereco(@RequestBody @Valid  NovoEnderecoRequest request){

        Endereco endereco = request.toModel(clienteRepository,cidadeRepository);

        enderecoRepository.save(endereco);

        return ResponseEntity.ok().build();
    }

}

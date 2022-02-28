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
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired

    private CidadeRepository cidadeRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<?>criarCliente(@RequestBody @Valid NovoClienteRequest request){

          Cliente cliente = request.toModel(cidadeRepository);

           clienteRepository.save(cliente);


        return ResponseEntity.ok().build();

    }
}

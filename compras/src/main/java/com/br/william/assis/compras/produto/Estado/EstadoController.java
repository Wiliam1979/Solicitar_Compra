package com.br.william.assis.compras.produto.Estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?>criarEstado(@RequestBody @Valid NovoEstadoRequest request, UriComponentsBuilder uriComponentsBuilder){

        Estado estado = request.toModel();

        estadoRepository.save(estado);
        URI uri = uriComponentsBuilder.path("/api/estado/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }
}

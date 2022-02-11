package com.br.william.assis.compras.cidade;

import com.br.william.assis.compras.produto.Estado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/cidade")
public class CidadeController {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

     @PostMapping
     @Transactional
    public ResponseEntity<?>criarCidade(@RequestBody @Valid NovoCidadeRequest request, UriComponentsBuilder uriComponentsBuilder){

        Cidade cidade = request.toModel(estadoRepository);

        cidadeRepository.save(cidade);

         URI uri = uriComponentsBuilder.path("/api/cidade/{id}").buildAndExpand(cidade.getId()).toUri();

         return ResponseEntity.created(uri).build();




    }
}

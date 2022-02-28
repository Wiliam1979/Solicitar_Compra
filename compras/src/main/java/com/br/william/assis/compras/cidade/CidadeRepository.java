package com.br.william.assis.compras.cidade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findById(Long id);
}

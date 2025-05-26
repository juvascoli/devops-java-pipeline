package br.com.fiap.moop.repository;

import br.com.fiap.moop.model.Galpao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GalpaoRepository extends JpaRepository<Galpao, Long> {

    Page<Galpao> findByLocalizacaoContaining(String localizacao, Pageable pageable);
}

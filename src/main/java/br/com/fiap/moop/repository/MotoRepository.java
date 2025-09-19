package br.com.fiap.moop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.moop.model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long>{

	List<Moto> findByPlacaContaining(String placa);

}

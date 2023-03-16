package br.com.fiap.Checkpoint1.repository;

import br.com.fiap.Checkpoint1.model.Carro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}

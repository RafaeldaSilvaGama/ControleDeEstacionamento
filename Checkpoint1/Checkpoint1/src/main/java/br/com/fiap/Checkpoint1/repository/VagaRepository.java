package br.com.fiap.Checkpoint1.repository;


import br.com.fiap.Checkpoint1.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}

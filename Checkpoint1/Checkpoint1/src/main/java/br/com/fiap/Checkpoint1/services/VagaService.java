package br.com.fiap.Checkpoint1.services;


import br.com.fiap.Checkpoint1.model.Vaga;
import br.com.fiap.Checkpoint1.repository.VagaRepository;
import org.springframework.stereotype.Service;

@Service
public class VagaService extends MyService<Vaga, Long>{

    public VagaService(VagaRepository repository) {super(repository);}
}

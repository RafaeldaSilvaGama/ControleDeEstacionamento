package br.com.fiap.Checkpoint1.services;

import br.com.fiap.Checkpoint1.model.Apartamento;
import br.com.fiap.Checkpoint1.repository.ApartamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartamentoService extends MyService<Apartamento, Long>{

    public ApartamentoService(ApartamentoRepository repository) {super(repository);}
}

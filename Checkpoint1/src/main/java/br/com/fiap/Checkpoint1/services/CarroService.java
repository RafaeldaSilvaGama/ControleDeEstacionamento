package br.com.fiap.Checkpoint1.services;

import br.com.fiap.Checkpoint1.model.Carro;
import br.com.fiap.Checkpoint1.repository.CarroRepository;
import org.springframework.stereotype.Service;

@Service
public class CarroService extends MyService<Carro, Long>{

    public CarroService(CarroRepository repository) {super(repository);}
}

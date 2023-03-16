package br.com.fiap.Checkpoint1.services;

import br.com.fiap.Checkpoint1.model.Usuario;
import br.com.fiap.Checkpoint1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService extends MyService<Usuario, Long>{

    public UsuarioService(UsuarioRepository repository) {super(repository);}
}
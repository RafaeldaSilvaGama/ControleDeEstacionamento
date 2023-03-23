package br.com.fiap.Checkpoint1.controller;


import br.com.fiap.Checkpoint1.dtos.CarroDto;
import br.com.fiap.Checkpoint1.model.Carro;
import br.com.fiap.Checkpoint1.model.Usuario;
import br.com.fiap.Checkpoint1.services.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Carro", description = "API para gerenciamento de veiculos")
@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarroController {

    final
    CarroService carroService;

    public CarroController(CarroService carroService) {this.carroService = carroService;}

    @Operation(summary = "Lista todos os veiculos", description = "Lista todos os veiculos")
    @GetMapping("/")
    public ResponseEntity<Object> Get(){
        return ResponseEntity.status(HttpStatus.OK).body(carroService.getAll());
    }


    @Operation(summary = "Recupera um veiculo pelo ID", description = "Recupera os dados de um veiculo a partir do seu ID")
    @ApiResponse(responseCode = "200", description = "Veiculo encontrado com sucesso", content = @Content(schema = @Schema(implementation = Carro.class)))
    @ApiResponse(responseCode = "404", description = "Veiculo não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Carro> getById(@PathVariable Long id) {
        Optional<Carro> optionalCarro = Optional.ofNullable(carroService.findById(id));

        if (optionalCarro.isPresent()) {
            return ResponseEntity.ok(optionalCarro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Salva o veiculo ", description = "Salva o veiculo")
    @ApiResponse(responseCode = "201", description = "Veiculo salvo com sucesso", content = @Content(schema = @Schema(implementation = Carro.class)))
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody @Valid CarroDto carroDto){
        var carro = new Carro();
        BeanUtils.copyProperties(carroDto, carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroService.save(carro));
    }


    @Operation(summary = "Altera um veiculo pelo ID", description = "altera os dados de um veiculo a partir do seu ID")
    @ApiResponse(responseCode = "200", description = "Veiculo encontrado com sucesso", content = @Content(schema = @Schema(implementation = Carro.class)))
    @ApiResponse(responseCode = "404", description = "Veiculo não encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid CarroDto carroDto) {
        Optional<Carro> optionalCarro = Optional.ofNullable(carroService.findById(id));
        if (!optionalCarro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }
        var carro = new Carro();
        BeanUtils.copyProperties(carroDto, carro);
        carro.setId(optionalCarro.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(carroService.save(carro));
    }


    @Operation(summary = "Exclui um Veiculo pelo Id" , description = "Exclui um veiculo a partir do seu ID")
    @ApiResponse(responseCode = "204", description = "veiculo excluido com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

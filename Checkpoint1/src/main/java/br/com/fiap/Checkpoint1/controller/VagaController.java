package br.com.fiap.Checkpoint1.controller;


import br.com.fiap.Checkpoint1.dtos.VagaDto;
import br.com.fiap.Checkpoint1.model.Usuario;
import br.com.fiap.Checkpoint1.model.Vaga;
import br.com.fiap.Checkpoint1.services.VagaService;
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

@Tag(name = "Vaga", description = "API para gerenciamento de vagas")
@RestController
@RequestMapping("/vaga")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VagaController {

    final
    VagaService vagaService;

    public VagaController(VagaService vagaService) {this.vagaService = vagaService;}

    @Operation(summary = "Lista todos as vagas", description = "Lista todas as vagas")
    @GetMapping("/")
    public ResponseEntity<Object> Get(){
        return ResponseEntity.status(HttpStatus.OK).body(vagaService.getAll());
    }


    @Operation(summary = "Recupera uma vaga pelo ID", description = "Recupera os dados de uma vaga a partir do seu ID")
    @ApiResponse(responseCode = "200", description = "Vaga encontrada com sucesso", content = @Content(schema = @Schema(implementation = Vaga.class)))
    @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<Vaga> getById(@PathVariable Long id) {
        Optional<Vaga> optionalVaga = Optional.ofNullable(vagaService.findById(id));

        if (optionalVaga.isPresent()) {
            return ResponseEntity.ok(optionalVaga.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Salva a vaga ", description = "Salva a vaga")
    @ApiResponse(responseCode = "201", description = "Vaga salva com sucesso", content = @Content(schema = @Schema(implementation = Vaga.class)))
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody @Valid VagaDto vagaDto){
        var vaga = new Vaga();
        BeanUtils.copyProperties(vagaDto, vaga);
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaService.save(vaga));
    }


    @Operation(summary = "Altera uma vaga pelo ID", description = "altera os dados de uma vaga a partir do seu ID")
    @ApiResponse(responseCode = "200", description = "Vaga alterada com sucesso", content = @Content(schema = @Schema(implementation = Vaga.class)))
    @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid VagaDto vagaDto) {
        Optional<Vaga> optionalVaga = Optional.ofNullable(vagaService.findById(id));
        if (!optionalVaga.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
        }
        var vaga = new Vaga();
        BeanUtils.copyProperties(vagaDto, vaga);
        vaga.setId(optionalVaga.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(vagaService.save(vaga));
    }
    @Operation(summary = "Exclui uma vaga pelo Id" , description = "Exclui uma vaga a partir do seu ID")
    @ApiResponse(responseCode = "204", description = "vaga excluida com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vagaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
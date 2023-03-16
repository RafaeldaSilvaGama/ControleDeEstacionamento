package br.com.fiap.Checkpoint1.controller;


import br.com.fiap.Checkpoint1.dtos.ApartamentoDto;
import br.com.fiap.Checkpoint1.model.Apartamento;
import br.com.fiap.Checkpoint1.model.Usuario;
import br.com.fiap.Checkpoint1.services.ApartamentoService;
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

@Tag(name = "Apartamento", description = "API para gerenciamento de apartamentos")
@RestController
@RequestMapping("/apartamento")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApartamentoController {

    final
    ApartamentoService apartamentoService;

    public ApartamentoController(ApartamentoService apartamentoService) {this.apartamentoService = apartamentoService;}

    @Operation(summary = "Lista todos os apartamentos", description = "Lista todos os apartamentos")
    @GetMapping("/")
    public ResponseEntity<Object> Get(){
        return ResponseEntity.status(HttpStatus.OK).body(apartamentoService.getAll());
    }

    @Operation(summary = "Salva o apartamento ", description = "Salva o apartamento")
    @ApiResponse(responseCode = "201", description = "Apartamento salvo com sucesso", content = @Content(schema = @Schema(implementation = Apartamento.class)))
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody @Valid ApartamentoDto apartamentoDto){
        var apartamento = new Apartamento();
        BeanUtils.copyProperties(apartamentoDto, apartamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(apartamentoService.save(apartamento));
    }

    @Operation(summary = "Recupera um apartamento pelo ID", description = "Recupera os dados de um apartamento a partir do seu ID")
    @ApiResponse(responseCode = "200", description = "Apartamento encontrado com sucesso", content = @Content(schema = @Schema(implementation = Apartamento.class)))
    @ApiResponse(responseCode = "404", description = "Apartamento não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Apartamento> getById(@PathVariable Long id) {
        Optional<Apartamento> optionalApartamento = Optional.ofNullable(apartamentoService.findById(id));

        if (optionalApartamento.isPresent()) {
            return ResponseEntity.ok(optionalApartamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Altera um apartamento pelo ID", description = "altera os dados de um apartamento a partir do seu ID")
    @ApiResponse(responseCode = "200", description = "Apartamento alterado com sucesso", content = @Content(schema = @Schema(implementation = Apartamento.class)))
    @ApiResponse(responseCode = "404", description = "Apartamento não encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid ApartamentoDto apartamentoDto) {
        Optional<Apartamento> optionalApartamento = Optional.ofNullable(apartamentoService.findById(id));
        if (!optionalApartamento.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apartamento não encontrado!");
        }
        var apartamento = new Apartamento();
        BeanUtils.copyProperties(apartamentoDto, apartamento);
        apartamento.setId(optionalApartamento.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(apartamentoService.save(apartamento));
    }

    @Operation(summary = "Exclui um apartamento pelo Id" , description = "Exclui um apartamento a partir do seu ID")
    @ApiResponse(responseCode = "204", description = "Apartamento excluido com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        apartamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

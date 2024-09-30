package io.github.juanmatias1.api_hotel.controller;

import io.github.juanmatias1.api_hotel.dto.QuartoDTO;
import io.github.juanmatias1.api_hotel.model.Quarto;
import io.github.juanmatias1.api_hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<QuartoDTO>> getAllQuartos() {
        List<QuartoDTO> quartos = quartoService.findAll().stream()
                .map(quarto -> new QuartoDTO(quarto.getId(), quarto.getTipo(), quarto.getPrecoPorNoite(), quarto.isDisponivel(), quarto.getHotel().getId()))
                .toList();
        return ResponseEntity.ok(quartos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDTO> getQuartoById(@PathVariable Long id) {
        Quarto quarto = quartoService.findById(id);
        QuartoDTO quartoDTO = new QuartoDTO(quarto.getId(), quarto.getTipo(), quarto.getPrecoPorNoite(), quarto.isDisponivel(), quarto.getHotel().getId());
        return ResponseEntity.ok(quartoDTO);
    }

    @PostMapping
    public ResponseEntity<QuartoDTO> createQuarto(@RequestBody QuartoDTO quartoDTO) {
        Quarto quarto = quartoService.createQuarto(quartoDTO);
        QuartoDTO createdQuartoDTO = new QuartoDTO(quarto.getId(), quarto.getTipo(), quarto.getPrecoPorNoite(), quarto.isDisponivel(), quarto.getHotel().getId());
        return ResponseEntity.status(201).body(createdQuartoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDTO> updateQuarto(@PathVariable Long id, @RequestBody QuartoDTO quartoDTO) {
        Quarto quartoAtualizado = quartoService.updateQuarto(id, quartoDTO);
        QuartoDTO updatedQuartoDTO = new QuartoDTO(quartoAtualizado.getId(), quartoAtualizado.getTipo(), quartoAtualizado.getPrecoPorNoite(), quartoAtualizado.isDisponivel(), quartoAtualizado.getHotel().getId());
        return ResponseEntity.ok(updatedQuartoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuarto(@PathVariable Long id) {
        quartoService.deleteQuarto(id);
        return ResponseEntity.noContent().build();
    }
}
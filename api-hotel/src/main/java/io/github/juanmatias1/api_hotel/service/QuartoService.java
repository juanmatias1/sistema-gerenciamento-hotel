package io.github.juanmatias1.api_hotel.service;

import io.github.juanmatias1.api_hotel.dto.QuartoDTO;
import io.github.juanmatias1.api_hotel.exception.ResourceNotFoundException;
import io.github.juanmatias1.api_hotel.model.Hotel;
import io.github.juanmatias1.api_hotel.model.Quarto;
import io.github.juanmatias1.api_hotel.repository.HotelRepository;
import io.github.juanmatias1.api_hotel.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Quarto> findAll() {
        return quartoRepository.findAll();
    }

    public Quarto findById(Long id) {
        return quartoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado"));
    }

    public Quarto createQuarto(QuartoDTO quartoDTO) {
        Hotel hotel = hotelRepository.findById(quartoDTO.getHotelId())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel não encontrado"));

        Quarto quarto = new Quarto();
        quarto.setTipo(quartoDTO.getTipo());
        quarto.setDisponivel(quartoDTO.isDisponivel()); // Boolean
        quarto.setPrecoPorNoite(quartoDTO.getPrecoPorNoite()); // Double
        quarto.setHotel(hotel); // Associando o hotel

        return quartoRepository.save(quarto);
    }

    public Quarto updateQuarto(Long id, QuartoDTO quartoDTO) {
        Quarto quarto = findById(id);

        Hotel hotel = hotelRepository.findById(quartoDTO.getHotelId())
                .orElseThrow(() -> new ResourceNotFoundException("Hotel não encontrado"));

        quarto.setTipo(quartoDTO.getTipo());
        quarto.setDisponivel(quartoDTO.isDisponivel()); // Boolean
        quarto.setPrecoPorNoite(quartoDTO.getPrecoPorNoite()); // Double
        quarto.setHotel(hotel); // Atualizando a associação do hotel

        return quartoRepository.save(quarto);
    }

    public void deleteQuarto(Long id) {
        Quarto quarto = findById(id);
        quartoRepository.delete(quarto);
    }
}
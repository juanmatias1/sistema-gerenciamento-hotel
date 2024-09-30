package io.github.juanmatias1.api_hotel.service;

import io.github.juanmatias1.api_hotel.dto.ReservaDTO;
import io.github.juanmatias1.api_hotel.exception.ResourceNotFoundException;
import io.github.juanmatias1.api_hotel.model.Quarto;
import io.github.juanmatias1.api_hotel.model.Reserva;
import io.github.juanmatias1.api_hotel.repository.QuartoRepository;
import io.github.juanmatias1.api_hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva createReserva(ReservaDTO reservaDTO) {
        Quarto quarto = quartoRepository.findById(reservaDTO.getQuartoId())
                .orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));

        if (!quarto.isDisponivel()) {
            throw new IllegalArgumentException("Quarto não está disponível");
        }

        Reserva reserva = new Reserva();
        reserva.setQuarto(quarto);
        reserva.setNomeHospede(reservaDTO.getNomeHospede());
        reserva.setDataEntrada(reservaDTO.getDataEntrada());
        reserva.setDataSaida(reservaDTO.getDataSaida());

        long dias = ChronoUnit.DAYS.between(reservaDTO.getDataEntrada(), reservaDTO.getDataSaida());
        reserva.setValorTotal(dias * quarto.getPrecoPorNoite());

        quarto.setDisponivel(false);

        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada"));
        reservaRepository.delete(reserva);
    }
}

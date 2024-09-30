package io.github.juanmatias1.api_hotel.controller;

import io.github.juanmatias1.api_hotel.dto.ReservaDTO;
import io.github.juanmatias1.api_hotel.model.Reserva;
import io.github.juanmatias1.api_hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<ReservaDTO> getAllReservas() {
        return reservaService.findAll().stream().map(reserva -> {
            ReservaDTO reservaDTO = new ReservaDTO();
            reservaDTO.setId(reserva.getId());
            reservaDTO.setNomeHospede(reserva.getNomeHospede());
            reservaDTO.setDataEntrada(reserva.getDataEntrada());
            reservaDTO.setDataSaida(reserva.getDataSaida());
            reservaDTO.setValorTotal(reserva.getValorTotal());
            reservaDTO.setQuartoId(reserva.getQuarto().getId());
            return reservaDTO;
        }).toList();
    }

    @PostMapping
    public ReservaDTO createReserva(@RequestBody ReservaDTO reservaDTO) {
        Reserva reserva = reservaService.createReserva(reservaDTO);

        ReservaDTO responseDTO = new ReservaDTO();
        responseDTO.setId(reserva.getId());
        responseDTO.setNomeHospede(reserva.getNomeHospede());
        responseDTO.setDataEntrada(reserva.getDataEntrada());
        responseDTO.setDataSaida(reserva.getDataSaida());
        responseDTO.setValorTotal(reserva.getValorTotal());
        responseDTO.setQuartoId(reserva.getQuarto().getId());

        return responseDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
    }


}
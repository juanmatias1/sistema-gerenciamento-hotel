package io.github.juanmatias1.api_hotel.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaDTO {
    private Long id;
    private Long quartoId;
    private String nomeHospede;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Double valorTotal;
}

package io.github.juanmatias1.api_hotel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    private String nomeHospede;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    private Double valorTotal;
}

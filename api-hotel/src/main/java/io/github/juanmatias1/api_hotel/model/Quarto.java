package io.github.juanmatias1.api_hotel.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private Double precoPorNoite;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    private boolean disponivel;
}

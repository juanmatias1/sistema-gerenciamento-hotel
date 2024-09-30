package io.github.juanmatias1.api_hotel.dto;

import lombok.Data;

import java.util.List;

@Data
public class HotelDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
    private List<QuartoDTO> quartos;
}

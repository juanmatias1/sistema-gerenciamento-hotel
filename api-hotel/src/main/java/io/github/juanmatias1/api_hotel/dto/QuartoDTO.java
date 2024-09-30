package io.github.juanmatias1.api_hotel.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuartoDTO {
    private Long id;
    private String tipo;
    private double precoPorNoite;
    private boolean disponivel;
    private Long hotelId;
}

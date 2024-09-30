package io.github.juanmatias1.api_hotel.controller;

import io.github.juanmatias1.api_hotel.dto.HotelDTO;
import io.github.juanmatias1.api_hotel.dto.QuartoDTO;
import io.github.juanmatias1.api_hotel.model.Hotel;
import io.github.juanmatias1.api_hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<HotelDTO> getAllHotels() {
        return hotelService.findAll().stream().map(hotel -> {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setId(hotel.getId());
            hotelDTO.setNome(hotel.getNome());
            hotelDTO.setEndereco(hotel.getEndereco());
            hotelDTO.setCidade(hotel.getCidade());
            hotelDTO.setEstado(hotel.getEstado());
            hotelDTO.setTelefone(hotel.getTelefone());

            List<QuartoDTO> quartosDTO = hotel.getQuartos().stream().map(quarto -> {
                QuartoDTO quartoDTO = new QuartoDTO();
                quartoDTO.setId(quarto.getId());
                quartoDTO.setTipo(quarto.getTipo());
                quartoDTO.setPrecoPorNoite(quarto.getPrecoPorNoite());
                quartoDTO.setDisponivel(quarto.isDisponivel());
                return quartoDTO;
            }).toList();

            hotelDTO.setQuartos(quartosDTO);
            return hotelDTO;
        }).toList();
    }

    @PostMapping
    public HotelDTO createHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelService.createHotel(hotelDTO);

        HotelDTO responseDTO = new HotelDTO();
        responseDTO.setId(hotel.getId());
        responseDTO.setNome(hotel.getNome());
        responseDTO.setEndereco(hotel.getEndereco());
        responseDTO.setCidade(hotel.getCidade());
        responseDTO.setEstado(hotel.getEstado());
        responseDTO.setTelefone(hotel.getTelefone());

        return responseDTO;
    }

    @PutMapping("/{id}")
    public HotelDTO updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelService.updateHotel(id, hotelDTO);

        HotelDTO responseDTO = new HotelDTO();
        responseDTO.setId(hotel.getId());
        responseDTO.setNome(hotel.getNome());
        responseDTO.setEndereco(hotel.getEndereco());
        responseDTO.setCidade(hotel.getCidade());
        responseDTO.setEstado(hotel.getEstado());
        responseDTO.setTelefone(hotel.getTelefone());

        return responseDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }

}

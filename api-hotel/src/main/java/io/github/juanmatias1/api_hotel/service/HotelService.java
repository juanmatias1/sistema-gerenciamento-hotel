package io.github.juanmatias1.api_hotel.service;

import io.github.juanmatias1.api_hotel.dto.HotelDTO;
import io.github.juanmatias1.api_hotel.exception.ResourceNotFoundException;
import io.github.juanmatias1.api_hotel.model.Hotel;
import io.github.juanmatias1.api_hotel.model.Quarto;
import io.github.juanmatias1.api_hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel createHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setNome(hotelDTO.getNome());
        hotel.setEndereco(hotelDTO.getEndereco());
        hotel.setCidade(hotelDTO.getCidade());
        hotel.setEstado(hotelDTO.getEstado());
        hotel.setTelefone(hotelDTO.getTelefone());
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, HotelDTO hotelDTO) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel não encontrado"));

        hotel.setNome(hotelDTO.getNome());
        hotel.setEndereco(hotelDTO.getEndereco());
        hotel.setCidade(hotelDTO.getCidade());
        hotel.setEstado(hotelDTO.getEstado());
        hotel.setTelefone(hotelDTO.getTelefone());
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel não encontrado"));
        hotelRepository.delete(hotel);
    }
}

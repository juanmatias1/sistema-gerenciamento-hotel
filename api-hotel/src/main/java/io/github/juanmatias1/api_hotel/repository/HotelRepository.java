package io.github.juanmatias1.api_hotel.repository;

import io.github.juanmatias1.api_hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
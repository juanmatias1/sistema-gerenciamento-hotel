package io.github.juanmatias1.api_hotel.repository;

import io.github.juanmatias1.api_hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}

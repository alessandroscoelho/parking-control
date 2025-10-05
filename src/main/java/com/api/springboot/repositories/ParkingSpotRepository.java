package com.api.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.springboot.models.ParkingSpotModel;

import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Integer>{

    boolean existsByPlacaDoVeiculo(String placaDoVeiculo);
    boolean existsByNumeroDaVaga(String numeroDaVaga);
    boolean existsByApartamento(String apartamento);

}

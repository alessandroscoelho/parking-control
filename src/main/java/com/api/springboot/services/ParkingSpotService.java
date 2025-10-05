package com.api.springboot.services;

import com.api.springboot.models.ParkingSpotModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.api.springboot.repositories.ParkingSpotRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {

    ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByParkingSpotNumber(String numeroDaVaga) {
        return parkingSpotRepository.existsByNumeroDaVaga(numeroDaVaga);
    }

    public boolean existsByLicencePlateCar(String placaDoVeiculo) {
        return parkingSpotRepository.existsByPlacaDoVeiculo(placaDoVeiculo);
    }

    public boolean existsByApartament(String apartamento) {
        return parkingSpotRepository.existsByApartamento(apartamento);
    }

    public List<ParkingSpotModel> findAll() {
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpotModel> findById(Integer id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}

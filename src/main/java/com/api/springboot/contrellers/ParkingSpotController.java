package com.api.springboot.contrellers;

import com.api.springboot.dtos.ParkingSpotDto;
import com.api.springboot.models.ParkingSpotModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.springboot.services.ParkingSpotService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/parking-spot")
public class ParkingSpotController {

    @Autowired
	final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {

        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getNumeroDaVaga())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já alocapa para um apartamento.");
        }
        if (parkingSpotService.existsByLicencePlateCar(parkingSpotDto.getPlacaDoVeiculo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa do veiculo já está em uso.");
        }
        if (parkingSpotService.existsByApartament(parkingSpotDto.getApartamento())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Apartamento já possuí um registro de vaga.");
        }

        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpot() {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        return parkingSpotModelOptional.<ResponseEntity<Object>>map(parkingSpotModel -> ResponseEntity.status(HttpStatus.OK).body(parkingSpotModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento inexistente."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable Integer id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga inexistente para exclusão.");
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vaga excluida com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable Integer id, @RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga inexistente para atualização.");
        }
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
        parkingSpotModel.setDataRegistro(parkingSpotModelOptional.get().getDataRegistro());
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    }
}

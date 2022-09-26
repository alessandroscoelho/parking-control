package com.api.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.springboot.models.ParkingSpotModel;
import com.api.springboot.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	@Autowired
	ParkingSpotRepository parkingSpotRepository;
	
	public ParkingSpotModel findById(Integer id) {
		
		return null;
	}

}

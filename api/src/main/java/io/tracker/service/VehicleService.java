package io.tracker.service;

import java.util.List;

import io.tracker.vehicles.Vehicles;

public interface VehicleService {

	
	List<Vehicles> findAll();
	Vehicles findOne(String vin);
	List<Vehicles> create(Vehicles vehicle);
	
	Vehicles update(String vin,Vehicles vehicle );
	void delete(String vin);
}

package io.tracker.repository;

import java.util.List;

import io.tracker.vehicles.Vehicles;

public interface VehicleRepository {

	
	List<Vehicles> findAll();

	Vehicles findOne(String vin);
	
	Vehicles create(Vehicles vehicle);

	Vehicles update(Vehicles vehicle);

    void delete(Vehicles vehicle);
}

package io.tracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.tracker.vehicles.VehicleReading;

@Repository
public class VehicleReadingRepoImpl implements VehicleReadingRepo {

	@PersistenceContext
	private EntityManager entityManager;

	public VehicleReading create(VehicleReading reading) {
		entityManager.persist(reading.getTires());

		// After getting the Vehicle readings, it will compare some fields by
		// business logic in Service class
		// and add alerts inside Alerts table.
		entityManager.persist(reading.getAlerts());
// persist all its children first then the parent which is reading.
		
		entityManager.persist(reading);

		return reading;
	}

}

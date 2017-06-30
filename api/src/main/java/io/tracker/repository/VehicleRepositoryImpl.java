package io.tracker.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import io.tracker.vehicles.Vehicles;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Vehicles> findAll() {
		
		TypedQuery<Vehicles> query = entityManager.createNamedQuery("Vehicles.findAll",
        Vehicles.class);
         return query.getResultList();
	}

	public Vehicles findOne(String vin) {
	
		return entityManager.find(Vehicles.class, vin);
	}

	public Vehicles create(Vehicles vehicle) {
		
		List<Vehicles> vehicleList = new ArrayList<Vehicles>();
		
		vehicleList.add(vehicle);
		entityManager.persist(vehicleList);
	
		return (Vehicles) vehicleList;
	}

	public Vehicles update(Vehicles vehicle) {		
		
		return entityManager.merge(vehicle);
	}

	public void delete(Vehicles vehicle) {
		entityManager.remove(vehicle);
		
	}

}

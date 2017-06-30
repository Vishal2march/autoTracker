package io.tracker.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.tracker.repository.VehicleRepository;
import io.tracker.vehicles.Vehicles;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository repository;
	
	 @Transactional
	public List<Vehicles> findAll() {
		
		return repository.findAll();
	}

	 @Transactional
	public Vehicles findOne(String vin) {
		
		Vehicles exist =  repository.findOne(vin);
		if (exist == null) {
           // throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
			System.out.println("vin does not exist");
        }
        return exist;
	}

	 @Transactional
	public List<Vehicles> create(Vehicles vehicle) {
		
		 List<Vehicles> list = new ArrayList<Vehicles>();
		 
		 list.add(repository.create(vehicle));
		 
		 // check if car vin is already exists then call the update method.
		 for(Vehicles vv: list){
			 
			 // check if vehicle with same vin is already present then call the update() method..
			 if(vv.getVin().equals(vehicle.getVin())){
				 repository.update(vehicle);
			 }
		 }
		return list;
	}
	 @Transactional
	public Vehicles update(String vin, Vehicles vehicle) {
			
			 repository.update(vehicle);
		
		return vehicle;
		
	}
    
	 @Transactional
	public void delete(String vin) {
		
		 Vehicles existing = repository.findOne(vin);
	        if (existing == null) {
	           // throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
	        }
	        repository.delete(existing);
		
	}

}

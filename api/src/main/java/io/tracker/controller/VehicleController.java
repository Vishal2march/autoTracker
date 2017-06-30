package io.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.tracker.service.VehicleService;
import io.tracker.vehicles.Vehicles;


@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value="/vehicles")
public class VehicleController {

	 @Autowired
	 VehicleService service;
	
@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicles> findAll(){
		return service.findAll();
		
	}

@RequestMapping(method = RequestMethod.GET, value = "/{id}",
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Vehicles findOne(@PathVariable("id") String vin){
	return service.findOne(vin);
	
}

// A kind of Upsert method with PUT request which will update & insert both
@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Vehicles create(@RequestBody Vehicles vehicle){
	
	//for(Vehicles c: vehicle){
		return (Vehicles) service.create(vehicle);
	
}

	
@RequestMapping(method = RequestMethod.PUT, value = "/{id}",
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Vehicles update(@PathVariable("id") String vin, @RequestBody Vehicles vehicle){
	
	//vehicle.setVin(vin);
		// this method will going to behave as an upsert() method.
	 
	return service.update(vin, vehicle);
	
}
@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
public void delete(@PathVariable("id") String vin){
	service.delete(vin);
}

}

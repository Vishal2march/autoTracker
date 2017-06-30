package io.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.tracker.service.VehicleReadingService;
import io.tracker.vehicles.Alerts;
import io.tracker.vehicles.VehicleReading;
import io.tracker.vehicles.Vehicles;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value="/readings")

public class VehicleReadingController {

	@Autowired
	VehicleReadingService service;
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public VehicleReading create(@RequestBody VehicleReading reading){
		return service.create(reading);
		
	}
	
}

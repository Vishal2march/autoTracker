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

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value="/readings",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class VehicleAlertsController {

	@Autowired
	VehicleReadingService service;
	
	@Async
	public void createAlerts(@RequestBody Alerts alert){
		service.createAlerts(alert);
		return;
	}
}

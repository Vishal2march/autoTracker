package io.tracker.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.tracker.repository.VehicleReadingRepo;
import io.tracker.vehicles.Alerts;
import io.tracker.vehicles.Alerts.PRIORITY;
import io.tracker.vehicles.VehicleReading;
import io.tracker.vehicles.Vehicles;

@Service
public class VehicleReadingServiceImpl implements VehicleReadingService {
	
	private Vehicles vehicle;
	private VehicleReading readings;
	
	@Autowired
	VehicleReadingRepo repository;
	
	@Transactional
	public VehicleReading create(VehicleReading reading) {
		
		
		return repository.create(reading);
			
	}
	
	@Transactional
	@Async
	public void createAlerts(Alerts alert){
		//Rule 1:
		if(readings.getEngineRpm() > vehicle.getRedlineRpm()){
			// Using ENUM here called PRIORITY to get all the values.
			String s = PRIORITY.HIGH.toString();
			alert.setPriority(s);
			alert.setAlertDescription("Priority Alert is High");
		}
		
		//Rule2:
			if(readings.getFuelVolume() < 10 % (vehicle.getMaxFuelVolume())){
				String t = PRIORITY.MEDIUM.toString();
				alert.setPriority(t);
				alert.setAlertDescription("Priority Alert is Medium");
			}
			
			//Rule3:
			if(readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontLeft()> 36){
				String r = PRIORITY.LOW.toString();
				alert.setPriority(r);
				alert.setAlertDescription("Priority Alert is Low for tires");
			}
			
			//Rule4:
			if(readings.isEngineCoolantLow()== true|| readings.isCheckEngineLightOn() == true){
				String str = PRIORITY.LOW.toString();
				alert.setPriority(str);
				alert.setAlertDescription("Priority Alert is Low for Engine");
			}
	}

}

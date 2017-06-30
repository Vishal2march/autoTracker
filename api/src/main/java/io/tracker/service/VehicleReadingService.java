package io.tracker.service;

import io.tracker.vehicles.Alerts;
import io.tracker.vehicles.VehicleReading;
import io.tracker.vehicles.Vehicles;

public interface VehicleReadingService {

	VehicleReading create(VehicleReading reading);
	public void createAlerts(Alerts alert);
}

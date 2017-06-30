package io.tracker.vehicles;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class VehicleReading {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	
	
	private String vin;
	private Long latitude;
	private Long longitude;
	private Timestamp timestamp;
	//private Instant timestamp;
	private Long fuelVolume;
	private Long speed;
	private String engineHp; 	
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private Long engineRpm;
	
	@ManyToOne
	private Vehicles vehicle;
	
	// Another entity class for tires readings.
	@OneToOne
	private Tires tires;
	
	@OneToMany
	private List<Alerts> alerts;
	//One reading has many alerts so mapping is OneToMany....
	
	public VehicleReading(){	
	}
	
	public VehicleReading(String vin, Timestamp timestamp){
		this.vin = vin;
		this.timestamp = timestamp;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	public Long getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(Long fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}

	public String getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(String engineHp) {
		this.engineHp = engineHp;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public Long getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(Long engineRpm) {
		this.engineRpm = engineRpm;
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	public List<Alerts> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alerts> alerts) {
		this.alerts = alerts;
	}

}

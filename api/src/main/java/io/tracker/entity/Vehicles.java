package io.tracker.vehicles;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name="Vehicles.findAll",query="SELECT vehicle from Vehicles vehicle ORDER BY vehicle.make DESC ")
})
public class Vehicles {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private String vin;	
	private String make;
	private String model;
	private Long year;
	private Long redlineRpm;
	private Long maxFuelVolume;
	private Timestamp lastServiceDate;
	
	public Vehicles(){
	}
	
	
	public Vehicles(String vin,
	 String make,
	 String model,
	 Long year,
	 Long redlineRpm,
	 Long maxFuelVolume,
	 Timestamp lastServiceDate)
	{
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.redlineRpm=redlineRpm;
		this.maxFuelVolume=maxFuelVolume;
		this.lastServiceDate=  lastServiceDate;
	}

	public String getVin() {
		return vin;
	}



	public void setVin(String vin) {
		this.vin = vin;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}

	public Long getYear() {
		return year;
	}


	public void setYear(Long year) {
		this.year = year;
	}


	public Long getRedlineRpm() {
		return redlineRpm;
	}


	public void setRedlineRpm(Long redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public Long getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(Long maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	

	public Timestamp getLastServiceDate() {
		return lastServiceDate;
	}


	public void setLastServiceDate(Timestamp lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}


	@Override
	public String toString() {
		return "Vehicles [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redlineRpm="
				+ redlineRpm + ", maxFuelVolume=" + maxFuelVolume + ", lastServiceDate=" + lastServiceDate + "]";
	}
	
	
}

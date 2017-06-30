package io.tracker.vehicles;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alerts {

	@Id
	private String vin;
	private String priority;
	private String alertDescription;
	
	public enum PRIORITY{
		HIGH,MEDIUM,LOW;
		
	}
	
	public Alerts(){
		
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAlertDescription() {
		return alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}
	
	
}

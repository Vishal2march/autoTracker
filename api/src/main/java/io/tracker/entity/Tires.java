package io.tracker.vehicles;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tires  {

	@Id
	private int frontLeft;
	private int frontRight;
	private int rearLeft;
	private int rearRight;
	
	public Tires(){	
	}

	public int getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeft(int frontLeft) {
		this.frontLeft = frontLeft;
	}

	public int getFrontRight() {
		return frontRight;
	}

	public void setFrontRight(int frontRight) {
		this.frontRight = frontRight;
	}

	public int getRearLeft() {
		return rearLeft;
	}

	public void setRearLeft(int rearLeft) {
		this.rearLeft = rearLeft;
	}

	public int getRearRight() {
		return rearRight;
	}

	public void setRearRight(int rearRight) {
		this.rearRight = rearRight;
	}

	
}

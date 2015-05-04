package com.julenhernandez.wumpus;

/**
 * Class of individual box, each box can contains warnings and main characters
 * 
 * @author Julen
 *
 */
public class Box {

	/**
	 * possilbe objects at each box
	 */
	private boolean wumpus;
	private boolean pit;
	private boolean bat;
	
	/**
	 * possible warnings at each box
	 */
	private boolean smell;
	private boolean breeze;
	private boolean noise;
	
	/**
	 * Builder of the class
	 */
	Box(){
		this.wumpus = false;
		this.pit = false;
		this.bat = false;
		this.smell = false;
		this.breeze = false;
		this.noise = false;
	}

	public boolean isWumpus() {
		return wumpus;
	}

	public void setWumpus(boolean wumpus) {
		this.wumpus = wumpus;
	}

	public boolean isPit() {
		return pit;
	}

	public void setPit(boolean pit) {
		this.pit = pit;
	}

	public boolean isBat() {
		return bat;
	}

	public void setBat(boolean bat) {
		this.bat = bat;
	}

	public boolean isSmell() {
		return smell;
	}

	public void setSmell(boolean smell) {
		this.smell = smell;
	}

	public boolean isBreeze() {
		return breeze;
	}

	public void setBreeze(boolean breeze) {
		this.breeze = breeze;
	}

	public boolean isNoise() {
		return noise;
	}

	public void setNoise(boolean noise) {
		this.noise = noise;
	}
	
	
}

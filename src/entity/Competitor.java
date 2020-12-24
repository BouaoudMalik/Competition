package entity;

import java.util.*;

/**
 * 
 * Competitor class i
 *
 */
public class Competitor {
	
	
	private String name;
	private int points;
	private static int competitorID=0;
	private int id;
	private int cote;
	
	/**
	 * constructor of the class
	 * @param name name of the competitor
	 * the competitor is also identified by 
	 * an ID and a number of points
	 */
	public Competitor(String name) {
		competitorID++;//auto increment ID
		this.id=competitorID;
		this.name=name;
		this.points=0;
		this.cote=0;
	}
	
	
	

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * setter on name
	 * @param name the competitor's name
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * getter of point
	 * @return the score of the competitor
	 */
	public int getPoints() {
		return this.points;
	}
	/**
	 * setter of points competitor
	 * @param points score 
	 */
	public void setPoints(int points) {
		this.points=points;
	}
	/**
	 * getter of ID 
	 * @return ID of the competitor
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * getter of cote
	 * @return the cote score
	 */
	public int getCote() {
		return cote;
	}

	/**
	 * setter of cote
	 * @param cote the cote to set
	 */
	public void setCote(int cote) {
		this.cote = cote;
	}



	@Override
	public String toString() {
		return this.name;
	}
}

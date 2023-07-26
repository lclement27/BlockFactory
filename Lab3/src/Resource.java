/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
******/

import java.lang.IllegalArgumentException;

/**
 * Class which represents a raw material resource. Each resource has a specific 
 * type and weight.
 * @author lucasclement
 *
 */
public class Resource {
	/**
	 * weight and type variables to be used
	 */
	private double weight;
	private ResourceType type;
	
	/**
	 * Constructor for the resource
	 * @param weight 	weight of the resource
	 * @param type		type of the resource
	 */
	public Resource(double weight, ResourceType type) {
		this.weight = weight;
		this.type = type;
	}
	
	/**
	 * Gets the weight of the resource
	 * @return the resource object's weight
	 */
	public double getWeight() {
		return this.weight;
	}
	
	/**
	 * Gets the type of the resource
	 * @return the resource object's type
	 */
	public ResourceType getType() {
		return this.type;
	}
	
	/**
	 * Adds weight to a resource
	 * Added weight must be positive and to the correct resource type
	 * @param weight weight to be added
	 * @param type   resource type the weight is to be added to
	 * @throws IllegalArgumentException
	 */
	public void addWeight(double weight, ResourceType type) throws IllegalArgumentException {
		if (weight < 0) {
			throw new IllegalArgumentException("Added weight must be a positive number");
		}
		
		if (type != this.type) {
			throw new IllegalArgumentException("Cannot add " + type + " weight to " + this.type + " weight");
		}
		
		else 		
			this.weight += weight;
	}
	
	/**
	 * Subtracts weight from a resource
	 * Subtracted weight must be positive, greater then the weight that is already present,
	 * and to the same resource type
	 * @param weight weight to be subtracted
	 * @param type   resource type the weight is to be subtracted from
	 * @throws IllegalArgumentException
	 */
	public void subtractWeight(double weight, ResourceType type) throws IllegalArgumentException {
		if (weight < 0) {
			throw new IllegalArgumentException("Subtracted weight must be a positive number");
		}
		
		if (weight > this.weight) {
			throw new IllegalArgumentException("Cannot subtract more weight than what is present");
		}
		
		if (type != this.type) {
			throw new IllegalArgumentException("Cannot subtract " + type + " weight from " + this.type + " weight");
		}
		
		else 
			this.weight -= weight;
	}
}
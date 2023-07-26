/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
******/

import java.lang.IllegalArgumentException;

/**
 * An abstract class that instantiates a block
 * Child classes must implement the breakBlock() method
 * @author lucasclement
 *
 */
abstract class Block extends Resource {
	
	private ResourceType type;
	private double weight;
	
	/**
	 * Two parameter constructor that takes a weight and resource type
	 * @param weight weight of the resource
	 * @param type   type of the resource
	 * @throws IllegalArgumentException
	 */
	public Block(double weight, ResourceType type) throws IllegalArgumentException {
		super(weight, type);
		if (weight < 0) {
			throw new IllegalArgumentException("Weight must be a positive number");
		}
		else
			this.weight = weight;
			this.type = type;
	}
	
	/**
	 * Two parameter constructor that takes two resource types
	 * @param type1	first resource type
	 * @param type2	second resource type
	 */
	public Block(ResourceType type1, ResourceType type2) {
		super((Const.STONE_BLOCK_WEIGHT * Const.NUM_STONE) + (Const.WOOD_BLOCK_WEIGHT * Const.NUM_WOOD), ResourceType.HOUSE);
		this.type = ResourceType.HOUSE;
		this.weight = (Const.STONE_BLOCK_WEIGHT * Const.NUM_STONE) + (Const.WOOD_BLOCK_WEIGHT * Const.NUM_WOOD);

		
	}
	
	/**
	 * returns type of the block
	 * @return block type
	 */
	public ResourceType getType() {
		return this.type;
	}
	
	/**
	 * returns the weight of the block
	 * @return block weight
	 */
	public double getWeight() {
		return this.weight;
	}
	
	/**
	 * Method to print the block by its weight and type
	 * @return string showing the block weight and type
	 */
	@Override
	public String toString() {
		String blockString = String.format(".2f", this.weight) + this.type;
		return blockString;
	}
	
	/**
	 * Abstract method that breaks a block
	 * All children must implement this class in their own way
	 */
	abstract Resource breakBlock();
}




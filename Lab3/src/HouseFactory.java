/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
******/

import java.lang.IllegalArgumentException;

/**
 * Factory class that produces House blocks
 * inherits from the Factory interface
 * @author lucasclement
 *
 */
public class HouseFactory implements Factory {
	
	private double numWoodBlocks;
	private double numStoneBlocks;
	
	/**
	 * Factory constructor that initializes the number of stored wood and stone blocks to 0
	 */
	public HouseFactory() {
		numWoodBlocks = 0;
		numStoneBlocks = 0;
	}
	
	/**
	 * Method to take in a resource for the factory to store
	 * Takes in any object, but it should be a Block of type Wood or Stone
	 * @param obj an Object of some class
	 * @throws IllegalArgumentException
	 */
	@Override
	public void takeResource(Object obj) throws IllegalArgumentException{
		if (obj instanceof Block) {
			Block resourceBlock = (Block) obj;
			if (resourceBlock.getType() == ResourceType.HOUSE) {
				throw new IllegalArgumentException("Cannot accept this Block type");
			}
			else
				switch (resourceBlock.getType()) {
				case WOOD: numWoodBlocks += 1; break;	//add to the block count
				case STONE: numStoneBlocks += 1; break;
				case HOUSE: break;
			}
		}
		else
			throw new IllegalArgumentException("Object not a Block");
			
	}
	
	/**
	 * Method to produce a House block
	 * If there are not enough resources, null is returned instead of a house block
	 */
	@Override
	public Block produce() {
		if (numWoodBlocks < Const.NUM_WOOD | numStoneBlocks < Const.NUM_STONE) {
			return null;
		}
		
		else {
			numWoodBlocks -= Const.NUM_WOOD;	//subtract from stored resources
			numStoneBlocks -= Const.NUM_STONE;
			HouseBlock house = new HouseBlock(ResourceType.WOOD, ResourceType.STONE);
			return house;
		}	
	}
	
	/**
	 * Displays the number of wood and stone blocks the factory is holding
	 */
	@Override
	public void displayInventory() {
		String inventory = "Wood: " + String.format("%2f", this.numWoodBlocks) + ", Stone: " + String.format("%2f", this.numStoneBlocks);
		System.out.println(inventory);
	}

	
}
/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
EXTENSION in produce() function. Used recursion to ensure there are enough resources available to create the block
******/

import java.lang.IllegalArgumentException;
import java.util.Random;

/**
 * Factory class that produces Wood blocks
 * inherits from the Factory interface
 * @author lucasclement
 *
 */
public class WoodBlockFactory implements Factory {
	
	private Resource bin;
	
	/**
	 * Factory constructor that sets the bin variable to be a Resource with 0 weight
	 */
	public WoodBlockFactory() {
		this.bin = new Resource(0, ResourceType.WOOD);
	}
	
	/**
	 * Method to take in a resource for the factory to store
	 * Takes in any object, but it should be a Resource of type Wood
	 * @param obj an Object of some class
	 * @throws IllegalArgumentException
	 */
	@Override
	public void takeResource(Object obj) throws IllegalArgumentException {
		if (obj instanceof Resource) {
			Resource resource = (Resource) obj;
			if (resource.getType() != ResourceType.WOOD) {
				throw new IllegalArgumentException("WoodBlockFactory can only take wood blocks");
			}
			
			else 
				this.bin.addWeight(resource.getWeight(), ResourceType.WOOD);
		}
		
		else 
			throw new IllegalArgumentException("Object is not a Resource");
	}
	
	/**
	 * Method to produce a wood block
	 * If there are not enough resources to produce the block, the factory takes in another
	 * block and tries to produce a block. This repeats until there are enough resources
	 * @return a new wood block
	 */
	@Override
	public Block produce() {
		if (bin.getWeight() < Const.WOOD_BLOCK_WEIGHT) {
			Random r = new Random();
			double weight = Math.round((Math.abs(r.nextDouble()))*100.0)/10.0 ;	// creates a random weight for the new resource
			Resource resource = new Resource(weight, ResourceType.WOOD);	// new resource to be taken in
			takeResource(resource);
			return produce();		// EXTENSION recursion
		}
		else {
			bin.subtractWeight(Const.WOOD_BLOCK_WEIGHT, ResourceType.WOOD);
			WoodBlock newBlock = new WoodBlock();
			return newBlock;
		}
	
	}
	
	/**
	 * Displays the amount of wood it has by the weight
	 */
	@Override
	public void displayInventory() {
		String inventory = String.format("%2f", bin.getWeight());
		System.out.println(inventory);
	}
}
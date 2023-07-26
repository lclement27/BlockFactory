/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
******/

/**
 * A class that inherits from the Block class and represents a wood block
 * @author lucasclement
 *
 */
public class WoodBlock extends Block {
	
	private double weight;
	
	/**
	 * No argument constructor that inherits from the Block constructor
	 */
	public WoodBlock() {
		super(Const.WOOD_BLOCK_WEIGHT, ResourceType.WOOD);
		}
	
	/**
	 * Implementation of the breakBlock abstract method from Block
	 * Broken wood blocks only return half the weight of the original block
	 * @return a new wood block with half the weight
	 */
	@Override
	public Resource breakBlock() {
		double newWeight = this.weight / 2;
		Resource newBlock = new Resource(newWeight, ResourceType.WOOD);
		return newBlock;
		}
}

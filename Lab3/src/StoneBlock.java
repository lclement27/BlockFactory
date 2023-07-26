/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
******/

/**
 * A class that inherits from the Block class and represents a stone block
 * @author lucasclement
 *
 */
public class StoneBlock extends Block {
	
	private double weight;
	
	/**
	 * No argument constructor that inherits from the Block constructor
	 */
	public StoneBlock() {
		super(Const.STONE_BLOCK_WEIGHT, ResourceType.STONE);
		}
	
	/**
	 * Implementation of the breakBlock abstract method from Block
	 * A broken stone block returns the whole weight of the original block
	 * @return a new stone block with the same weight
	 */
	@Override
	public Resource breakBlock() {
		Resource newBlock = new Resource(this.weight, ResourceType.STONE);
		return newBlock;
		}
}
/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
******/


/**
 * A class that inherits from the Block class and represents a house block
 * @author lucasclement
 *
 */
public class HouseBlock extends Block{
	
	/**
	 * Two argument constructor that takes two resource types to create the house block
	 * @param wood	wood block resource
	 * @param stone	stone block resource
	 */
	public HouseBlock(ResourceType wood, ResourceType stone){
		super(wood, stone);	
	}
	
	/**
	 * Implementation of the breakBlock abstract method from Block
	 * Breaking a house block only returns the stone resource, not the wood
	 * @return a new stone block of constant weight
	 */
	@Override
	public Resource breakBlock() {
		//Resource newBlock = new Resource(this.weight, ResourceType.STONE);
		Resource newBlock = new Resource(Const.STONE_BLOCK_WEIGHT, ResourceType.STONE);
		return newBlock;
	}
}
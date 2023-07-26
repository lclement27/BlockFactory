/******
Name: Lucas Clement
Assignment: Lab 3
Date: 10/05/22
Notes: 
******/

/**
 * Interface for a factory that creates a certain block
 * @author lucasclement
 *
 */
interface Factory {
	
	/**
	 * Takes in a resource to be added to a bin
	 * @param mat	resource material that is being taken in
	 */
	public void takeResource(Object obj);

	
	/**
	 * Produces a a new block, type depends on the factory
	 * @return a new resource block
	 */
	public Block produce();
	
	
	/**
	 * Displays the resources the factory has to work with
	 */
	public void displayInventory();
	
	
}
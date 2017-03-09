package hairdresser;
/**
 * This class creates a new customer object with an integer id for tracking
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class NewCustomer {
	
	private static int id = -1; // Simpler 

	/**
	 * 
	 * @return a new customer with a specific id.
	 */
	public static Customer create() {
		id++;
		return new Customer(id);

	}

}

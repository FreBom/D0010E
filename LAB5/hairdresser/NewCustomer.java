package hairdresser;

public class NewCustomer {

	private static int id = 0;

	/*
	 * Create a new customer
	 * 
	 * @return the new customer
	 */
	/**
	 * 
	 * @return a new customer with a specific id.
	 */
	public static Customer create() {
		id++;
		return new Customer(id);

	}

}

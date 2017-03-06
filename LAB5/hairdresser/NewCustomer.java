package hairdresser;

public class NewCustomer {

	private int id = 0;

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
		int id = +1;
		return new Customer(id);

	}
	/**
	 * 
	 * @NOTDONE this method is probably not done or working as intended.
	 * @DONTUSETHISMETHOD 
	 */
	public int customers() {// TODO what do you want to do with this method?
							// Misleading name! And besides we already have an
							// GetId method in the customer class.
		return id;
	}

}

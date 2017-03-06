package hairdresser;

public class NewCustomer {
	
	private int id = 0;
	
	/* Create a new customer
	 * 
	 *@return the new customer
	 * */
	
	public static Customer create(){
		id =+ 1;
		return new Customer(id);
		
	}
	
	public int customers() {
		return id;
	}

}


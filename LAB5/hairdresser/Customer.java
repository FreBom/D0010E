package hairdresser;


public class Customer {
	/**
	 * This class specifies every customer
	 * 
	 * @author arostr-5, Fanny, Dexmo
	 */
	private int id;
	private boolean hasCut = false;
	private boolean hasReturn = false;
	private double enterTime;
	
	/**
	 * 
	 * @param id given by NewCustomer
	 */
	public Customer(int id){
		this.id = id;
		
	}
	
	/**
	 * Set if customer has gotten haircut
	 * 
	 */
	public void setHasCut() {
		hasCut = true;
	}
	
	public boolean getHasCut() {
		return hasCut;
	}
	
	public void setHasReturn() {
		hasReturn = true;
	}
	
	public boolean getHasReturn() {
		return hasReturn;
	}

	public void setEnterTime(double enterTime) {
		this.enterTime = enterTime;
	}
	
	public double getEnterTime() {
		return enterTime;
	}
	/**
	 * 
	 * @return the ID (identification tag) of the specific customer object
	 */
	public int getID(Customer customer){
		return  this.id;
	}
			
		
}



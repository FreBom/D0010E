package hairdresser;


public class Customer {
	
	private int id;
	private boolean hasCut = false;
	private boolean hasReturn = false;
	
	public Customer(int id){
		this.id = id;
		
	}
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
	/**
	 * 
	 * @return the ID (identification tag) of the specific customer object
	 */
	public int getID(Customer customer){
		return  this.id;
	}
			
		
}



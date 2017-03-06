package hairdresser;

import java.util.ArrayList;


import generalSimulator.EventStore;
/**
 * 
 * @author Dexmo ,Aron ,Fanny
 *
 */


public class FIFO extends generalSimulator.EventStore{
	private static int numLost = 0;
	private static int numCustomers = 0;
	public static int getCustomers() {
		return numCustomers - numLost;
	}
	
	private static ArrayList<Customer> newCustomerQueue = new ArrayList<Customer>();
	private static ArrayList<Customer> oldCustomerQueue = new ArrayList<Customer>();
	private static ArrayList<Customer> customerGettingHaircut = new ArrayList<Customer>();
	
	private static int queueLength = hairdresser.HairdressState.getQueueLength(); 
	private static int numberOfCuttingChairs = hairdresser.HairdressState.getNumberOfChairs(); 
	
	/**
	 * 
	 * @return the number of hairCuttingChairs that are not being use at this time.
	 */
	public static int idle(){
		return numberOfCuttingChairs - customerGettingHaircut.size();
	}
	/**
	 * 
	 * @param customer is the customer object that will be added to the list: customerGettingHaircut
	 */

	
	
	public static void addCustomer(Customer customer) {
		customerGettingHaircut.add(customer);
		numCustomers++;
	}
	
	public static void addNew(Customer customer) {
		if((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength){ 
			numLost ++;
		}
		else{  								

			newCustomerQueue.add(customer); 
		}
		numCustomers++;
	}
		
	
	public static void addOld(Customer customer) {
		if((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength){ 
			removeLast();    
			numLost ++;
		}
		oldCustomerQueue.add(customer);
	}
	
	
	public int numWaiting() {
		return (oldCustomerQueue.size() + newCustomerQueue.size());
	}
	
	public static void removeLast(){
		newCustomerQueue.remove(-1);	
	}

	public static void addGetHaircut(Customer readyCustomer){  
		for(int i = 0; i < customerGettingHaircut.size() ; i++ ){  
			if(customerGettingHaircut.get(i) == readyCustomer){
				customerGettingHaircut.remove(i);
			}
		}
		int i = 1; 
		Customer customerInQueue;
		if(oldCustomerQueue.size() >= i) {  
			customerInQueue = oldCustomerQueue.get(i);
			customerGettingHaircut.add(customerInQueue);
			oldCustomerQueue.remove(i); 
		}
		else if(newCustomerQueue.size() >= i) {  
			customerInQueue = newCustomerQueue.get(i); 
			customerGettingHaircut.add(customerInQueue);
			newCustomerQueue.remove(i);	
		}	
		//lägg tull event leave
	}
	
}

package hairdresser;

import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.State;

import generalSimulator.EventStore;
/**
 * 
 * @author Dexmo ,Aron ,Fanny
 *
 */


public class FIFO extends generalSimulator.EventStore{
	private int numCustomers = 0;
	private int numLost = 0;
	
	private ArrayList<Customer> newCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> oldCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> customerGettingHaircut = new ArrayList<Customer>();
	
	private int queueLength = hairdresser.HairdressState.getQueueLength(); 
	private int numberOfCuttingChairs = hairdresser.HairdressState.getNumberOfChairs(); 
	private boolean newCustomer;  
	
	/**
	 * 
	 * @return the number of hairCuttingChairs that are not being use at this time.
	 */
	public int idle(){
		return numberOfCuttingChairs - customerGettingHaircut.size();
	}
	/**
	 * 
	 * @param customer is the customer object that will be added to the list: customerGettingHaircut
	 */
	public void addNew(State state, EventStore store ,Customer customer) {
		if(customerGettingHaircut.size() == numberOfCuttingChairs){  
			addQueueNew(customer);      
			}
		else{
			customerGettingHaircut.add(customer);	
			generalSimulator.EventStore.add(new CustomerLeaves(state, store, customer));
		}

	}
	
	public void addOld(Customer customer) {
		if(customerGettingHaircut.size() == numberOfCuttingChairs){  
			addQueueOld(customer);     
			}
		else{
			customerGettingHaircut.add(customer);	
			generalSimulator.EventStore.add(new CustomerLeaves(state, store, customer));
		}

	}
	
	
	public int numWaiting() {
		return (oldCustomerQueue.size() + newCustomerQueue.size());
	}
	
	public void removeLast(){
		newCustomerQueue.remove(-1);	
	}

	public void addQueueNew(Customer customer){
		numCustomers ++; //sparar antalet kunder
		if((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength){ 
			numLost ++;
		}
		else{  								
			this.newCustomer = false;
			newCustomerQueue.add(customer); 
		}
	}
		
	public void addQueueOld(Customer customer){	
		if((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength){ 
			removeLast();    
			numLost ++;
		}
		oldCustomerQueue.add(customer);
	
	}
	/**
	 * 
	 * @param readyCustomer
	 */
	public void addGetHaircut(Customer readyCustomer){  
		for(int i = 0; i < customerGettingHaircut.size() ; i++ ){  
			if(customerGettingHaircut.get(i) == readyCustomer){
				customerGettingHaircut.remove(i);
			}
		}
		int i = 1; 
		Customer customerInQueue;
		if(oldCustomerQueue.size() >= i){  
			customerInQueue = oldCustomerQueue.get(i);
			customerGettingHaircut.add(customerInQueue);
			oldCustomerQueue.remove(i); 
		}
		else if(newCustomerQueue.size() >= i){  
			customerInQueue = newCustomerQueue.get(i); 
			customerGettingHaircut.add(customerInQueue);
			newCustomerQueue.remove(i);	
		}	
	}
	
}

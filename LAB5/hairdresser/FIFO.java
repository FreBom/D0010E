package hairdresser;

import java.util.ArrayList;
import hairdresser.Customer;
import generalSimulator.EventStore;

/**
 * 
 * @author Dexmo ,Aron ,Fanny
 *
 */

public class FIFO {

	private int numLost = 0;
	private int max;
	private double tempCutTime;
	
// The customer arraylist
	private ArrayList<Customer> newCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> oldCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> customerGettingHaircut = new ArrayList<Customer>();

	private int maxQueueLength = HairdressState.queueLength;
	private int numberOfCuttingChairs = HairdressState.numberOfChairs;


	/**
	 * 
	 * @return the number of hairCuttingChairs that are not being used at this
	 *         time.
	 */

	public void addcustomerGettingHaircut(Customer customer) {
		customerGettingHaircut.add(customer);

	}
	
	/**
	 * 
	 * The method removes the last customer in the customer Arraylist.
	 * 
	 * @param customerQueue
	 * 				is a queue with customers.
	 */

	public void removeLast(ArrayList<Customer> customerQueue) {
		customerQueue.remove(customerQueue.size() - 1);
	}
	
	/**
	 * 
	 * @return the number of hairCuttingChairs that are not being used at this
	 *         time.
	 */
	
	public int idle() {
		return numberOfCuttingChairs - customerGettingHaircut.size();
	}
	
	
/**
 *  If numWaiting() (the size of the queue) is bigger than the max,
 *   the numWaiting() is the new max.
 *   
 */

	public void setMax() {
		if (numWaiting() > max) {
			max = numWaiting();
		}
	}
	
/**
 * 
 * @return max, the max size of the queue.
 * 
 */

	public int getMax() {
		return max;
	}

	/**
	 * 
	 * @param customer
	 *            is the customer object that will be added to the list:
	 *            customerGettingHaircut
	 */

	public void addCustomer(Customer customer) {
		customerGettingHaircut.add(customer);
	}

	/**
	 * Tries to add a new customer to the simulation. If the customer is not
	 * added then we count it as lost revenue. Call the method setMax() if 
	 * the queue get a new size.
	 * 
	 * 
	 * @param customer
	 *            is the customer that will be added or lost.
	 * @NOTE this add method adds a customer to the Arraylist :
	 *       <b>newCustomerQueue</b>
	 */
	public void addNew(Customer customer) {
		if (numWaiting() == maxQueueLength) {
			numLost++;
		} else {

			newCustomerQueue.add(customer);
			setMax();
		}
	}

	/**
	 * Tries to add a old customer to the simulation. If the queue is full,
	 *  it will check if there are any new customers in the queue. If it is,
	 *  it will remove the new customer who came in last, and then place it into the old customer
	 *  in the queue for old customers. If the old customer is not added then we count it as lost
	 *  revenue. Call the method setMax() if the queue get a new size.
	 * 
	 * @param customer
	 *            is the customer that will be added or lost.
	 * @NOTE this add method adds a customer to the Arraylist :
	 *       <b>oldCustomerQueue</b>
	 */
	public void addOld(Customer customer) {
		if (numWaiting() == maxQueueLength) {
			if (newCustomerQueue.size() > 0) {
				removeLast(newCustomerQueue);// removeLast();
				oldCustomerQueue.add(customer);
			}
			numLost++;
		} else {
			oldCustomerQueue.add(customer);
			setMax();
		}
	}

	/**
	 * 
	 * @return The total amount of customers (both old an new) waiting inside
	 *         the hairsaloon.
	 */
	public int numWaiting() {
		return (oldCustomerQueue.size() + newCustomerQueue.size());
	}

	
	/**
	 * 
	 * @return numLost, the numbers of customer that have been lost.
	 */
	public int getNumLost() {
		return numLost;
	}
/**
 * 
 * First we remove the customer as received a haircut of customerGettingHaircut.
 * Then we will add a customer in queue to the customerGettingHaircut. 
 * 
 * If there is a customer in the oldCustomerQueue,we will add this customer to 
 * the customerGettingHaircut and remove the customer from the oldCustomerQueue. 
 * A done-event is also created for this customer.
 * 
 * If the oldCustomerQueue was empty, we check if  there is a customer in the
 * newCustomerQueue. If there is a customer in the newCustomerQueue, we will
 * add this customer to the customerGettingHaircut and remove the customer
 * from the newCustomerQueue. A done-event is also created for this customer.
 * 
 * 
 * @param customer 
 * 		is the done customer as received a haircut. This customer
 *  	will be removed from the customerGettingHaircut queue. 
 *  
 * @param state
 * 		is the HairdressState.
 * 
 * @param store
 * 		is the EventStore we add new done-events too.
 */
	public void addGetHaircut(Customer customer, HairdressState state, EventStore store) {
		
		for (int i = 0; i < customerGettingHaircut.size(); i++) {    //Tar bort den färdigklippta kunden från customerGettingHaircut
			if (customerGettingHaircut.get(i) == customer) {
				customerGettingHaircut.remove(i);
			}
		}
		Customer fisrtCustomerInQueue;
		
		if (oldCustomerQueue.size() > 0) {  				 //om det finns någon customer i oldCustomerQueue
			fisrtCustomerInQueue = oldCustomerQueue.get(0);
			customerGettingHaircut.add(fisrtCustomerInQueue); // kommer den första i kön läggas till i customerGettingHaircut.
			tempCutTime = state.getCutTime();
			store.add(new Done(fisrtCustomerInQueue, state.getTime() + tempCutTime, store)); //Skapas ett done-event för customern
			state.setAverageCutTime(tempCutTime);
			oldCustomerQueue.remove(0);                  	//Sen kommer den tas bort från oldCustomerQueue.
			
		} else if (newCustomerQueue.size() > 0) { 			//annars om det finns någon customer i newCustomerQueue, 
			fisrtCustomerInQueue = newCustomerQueue.get(0);	 
			customerGettingHaircut.add(fisrtCustomerInQueue); //kommer den första i kön läggas till i customerGettingHaircut. 
			tempCutTime = state.getCutTime();      

			store.add(new Done(fisrtCustomerInQueue, state.getTime() + tempCutTime, store)); //skapas ett Done-event för customern som placerats in
			state.setAverageCutTime(tempCutTime);
			newCustomerQueue.remove(0);      				//Sen kommer den tas bort från newCustomerQueue. 
		}

	}
	

}

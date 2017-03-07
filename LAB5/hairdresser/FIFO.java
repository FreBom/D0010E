package hairdresser;

import java.util.ArrayList;
import hairdresser.Customer;

import generalSimulator.EventStore;
import generalSimulator.Simulator;

/**
 * 
 * @author Dexmo ,Aron ,Fanny
 *
 */

public class FIFO extends EventStore {
	private static int numLost = 0;
	private static int numCustomers = 0;

	/**
	 * 
	 * @return the total amount of customers that we have made a profit on
	 */
	public static int getCustomers() {
		return numCustomers - numLost;
	}

	private static ArrayList<Customer> newCustomerQueue = new ArrayList<Customer>();
	private static ArrayList<Customer> oldCustomerQueue = new ArrayList<Customer>();
	private static ArrayList<Customer> customerGettingHaircut = new ArrayList<Customer>();

	private static int queueLength = HairdressState.getQueueLength();
	private static int numberOfCuttingChairs = HairdressState.getNumberOfChairs();

	/**
	 * 
	 * @return the number of hairCuttingChairs that are not being used at this
	 *         time.
	 */
	public static int idle() {
		return numberOfCuttingChairs - customerGettingHaircut.size();
	}

	/**
	 * 
	 * @param customer
	 *            is the customer object that will be added to the list:
	 *            customerGettingHaircut
	 */

	public static void addCustomer(Customer customer) {
		customerGettingHaircut.add(customer);
		numCustomers++;
	}
	/**
	 * Tries to add a new customer to the simulation. If the customer is not added then we count it as lost revenue.
	 * @param customer is the customer that will be added or lost.
	 * @NOTE this add method adds a customer to the Arraylist : <b>newCustomerQueue</b>
	 */
	public static void addNew(Customer customer) {
		if ((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength) {
			numLost++;
		} else {

			newCustomerQueue.add(customer);
		}
		numCustomers++;
	}
	/**
	 * Tries to add a new customer to the simulation. If the customer is not added then we count it as lost revenue.
	 * @param customer is the customer that will be added or lost.
	 * @NOTE this add method adds a customer to the Arraylist : <b>oldCustomerQueue</b>
	 */
	public static void addOld(Customer customer) {
		if ((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength) {
			removeLast();
			numLost++;
		}
		oldCustomerQueue.add(customer);
	}
	/**
	 * 
	 * @return The total amount of customers (both old an new) waiting inside the hairsaloon.
	 */
	public int numWaiting() {
		return (oldCustomerQueue.size() + newCustomerQueue.size());
	}
	/**
	 * Removes the last customer from the Arraylist: <code>newCustomerQueue</code>
	 * @NOTE this method is static and we might want to change this.
	 */
	public static void removeLast() {//TODO make dynamic and remove the @NOTE tag above!
		newCustomerQueue.remove(-1);
		
	}
	/**
	 * 
	 * @param customerQueue The queue that we want to remove the last element from.
	 */
	public void NEWremoveLast(ArrayList<Customer> customerQueue){
		customerQueue.remove(-1);
	}
	/**
	 * 
	 * @param readyCustomer The customer that has gotten their hair cut and is ready to pay and leave.
	 * @param state 
	 * @param store
	 */
	public static void addGetHaircut(Customer readyCustomer, HairdressState state, EventStore store) {
		for (int i = 0; i < customerGettingHaircut.size(); i++) {
			if (customerGettingHaircut.get(i) == readyCustomer) {
				customerGettingHaircut.remove(i);
			}
		}
		int i = 1;
		Customer customerInQueue;
		if (oldCustomerQueue.size() >= i) {
			customerInQueue = oldCustomerQueue.get(0);
			customerGettingHaircut.add(customerInQueue);
			store.add(new CustomerLeaves(customerInQueue, Simulator.getSimTime() + state.getCutTime(), store));
			oldCustomerQueue.remove(0);
		} else if (newCustomerQueue.size() >= i) {
			customerInQueue = newCustomerQueue.get(0);
			customerGettingHaircut.add(customerInQueue);
			store.add(new CustomerLeaves(customerInQueue, Simulator.getSimTime() + state.getCutTime(), store));
			newCustomerQueue.remove(0);
		}
		// lägg tull event leave
	}

}

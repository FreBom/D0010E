package hairdresser;

import java.util.ArrayList;
import hairdresser.Customer;

import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;

/**
 * 
 * @author Dexmo ,Aron ,Fanny
 *
 */

public class FIFO extends HairdressState {
	private int numLost = 0;
	private static int numCustomers = 0;

	/**
	 * 
	 * @return the total amount of customers that we have made a profit on
	 */
	public int getCustomers() {//var static
		return numCustomers - numLost;
	}

	private ArrayList<Customer> newCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> oldCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> customerGettingHaircut = new ArrayList<Customer>();

	private int maxQueueLength = queueLength;
	private int numberOfCuttingChairs = numberOfChairs;
	
	/**
	 * 
	 * @return the number of hairCuttingChairs that are not being used at this
	 *         time.
	 */
	public int idle() {//var static
		return numberOfCuttingChairs - customerGettingHaircut.size();
	}

	/**
	 * 
	 * @param customer
	 *            is the customer object that will be added to the list:
	 *            customerGettingHaircut
	 */

	public void addCustomer(Customer customer) {//var static
		customerGettingHaircut.add(customer);
		numCustomers++;
	}
	/**
	 * Tries to add a new customer to the simulation. If the customer is not added then we count it as lost revenue.
	 * @param customer is the customer that will be added or lost.
	 * @NOTE this add method adds a customer to the Arraylist : <b>newCustomerQueue</b>
	 */
	public void addNew(Customer customer) {//var static
		if ((oldCustomerQueue.size() + newCustomerQueue.size()) == maxQueueLength) {
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
	public void addOld(Customer customer) {
		if ((oldCustomerQueue.size() + newCustomerQueue.size()) == maxQueueLength) {
			NEWremoveLast(newCustomerQueue);//removeLast();
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
	
	public int getNumLost() {
		return numLost;
	}
	/*
	 * Removes the last customer from the Arraylist: <code>newCustomerQueue</code>
	 * @NOTE this method is static and we might want to change this.
	 *
	public static void removeLast() {//TODO make dynamic and remove the @NOTE tag above!
		newCustomerQueue.remove(-1);
		
	}*/
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
	public void addGetHaircut(Customer readyCustomer, HairdressState state, EventStore store, Simulator sim) {//var static samt bytte från Eventstore till FIFO
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
			store.add(new CustomerLeaves(customerInQueue, sim.getSimTime() + state.getCutTime(), store, this));
			oldCustomerQueue.remove(0);
		} else if (newCustomerQueue.size() >= i) {
			customerInQueue = newCustomerQueue.get(0);
			customerGettingHaircut.add(customerInQueue);
			store.add(new CustomerLeaves(customerInQueue, sim.getSimTime() + state.getCutTime(), store, this));
			newCustomerQueue.remove(0);
		}
	
	}

}

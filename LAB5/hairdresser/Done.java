package hairdresser;

import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;

/**
 * This class handle the event Done which occurs when a customer has gotten their haircut
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class Done extends Event {

	private Customer customer;
	private HairdressState HSState;
	private double tempCutTime;
	/**
	 * Constructor need the unique customer, time when it occurs and the store of events
	 * 
	 * @param customer is unique
	 * @param time is unique when it occurs
	 * @param store holds the event
	 */
	public Done(Customer customer, double time, EventStore store) {
		super(time, store);
		this.customer = customer;

	}
	
	/**
	 * The effect of this event, assigning, counting and randomize
	 * 
	 * @param the specified state
	 */
	public void execute(State state) {

		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.setCustomerID(customer.getID(this.customer));

		updateWaitTime(HSState);
		updateIdleTime(HSState);
		HSState.setTime(getTime());
		HSState.update();

		if (!customer.getHasCut()) { // As long the customers first cut we want to count

			HSState.setCutCustomer();
			customer.setHasCut();

		}

		if (HSState.getDissatisfied()) { // If the customer will be returning

			getStore().add(new Return(customer, getTime() + HSState.getReturnTime(), getStore()));
			
		}
	
		Customer customerFirst = HSState.getFIFO().addGetHairCut(customer);
		
		if(!(customerFirst == null)){
			tempCutTime = HSState.getCutTime();  
			getStore().add(new Done(customerFirst, getTime() + tempCutTime, getStore()));
			HSState.setAverageCutTime(tempCutTime);
			
		}
		
		
	}
	/**
	 * The waitTime is handled and updated when the events occurs
	 * 
	 * @param HSState which is the specified state of the simulation, this is very specific
	 */
	private void updateWaitTime(HairdressState HSState) {
		HSState.addWaitingTime((HSState.getFIFO().numWaiting()) * (getTime() - HSState.getTime()));

	}
	
	/**
	 * The idleTime is handled and updated when the events occurs
	 * 
	 * @param HSState the specified state
	 */
	private void updateIdleTime(HairdressState HSState) {
		HSState.addIdleTime((HSState.getFIFO().idle()) * (getTime() - HSState.getTime()));

	}

}
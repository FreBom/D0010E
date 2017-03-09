package hairdresser;

import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;
/**
 * This class handles the return event
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class Return extends Event {

	private Customer customer;
	private double tempCutTime;
	HairdressState HSState;
	/**
	 * Constructor needs what customer are returning, the time of the event and the places it's stored
	 * 
	 * @param customer which is specified when event is created
	 * @param time of the event
	 * @param store were the event is stored
	 */
	public Return(Customer customer, double time, EventStore store) {
		super(time, store);
		this.customer = customer;
	}
	/**
	 * The effect of the event handles if customer has returned before and making sure the salon
	 * has a spot
	 * 
	 */
	public void execute(State state) {

		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.setCustomerID(customer.getID(this.customer));

		updateWaitTime(HSState);
		updateIdleTime(HSState);
		HSState.setTime(getTime());
		HSState.update();

		if (customer.getHasReturn() == false) {
			HSState.setReturnCustomer();
			customer.getHasReturn();
		}

		if (HSState.getFIFO().idle() > 0) {
			HSState.getFIFO().addCustomer(customer);
			tempCutTime = HSState.getCutTime();
			getStore().add(new Done(customer, getTime() + tempCutTime, getStore()));
			HSState.setAverageCutTime(tempCutTime);

		} else {
			HSState.getFIFO().addOld(customer);
		}

	}
	
	/**
	 * The waitTime is handled and updated when the events occurs
	 * 
	 * @param HSState which is the specified state of the simulation, this is very specific
	 */
	public void updateWaitTime(HairdressState HSState) {
		HSState.addWaitingTime((HSState.getFIFO().numWaiting()) * (getTime() - HSState.getTime()));

	}
	
	
	/**
	 * The idleTime is handled and updated when the events occurs
	 * 
	 * @param HSState the specified state
	 */
	public void updateIdleTime(HairdressState HSState) {
		HSState.addIdleTime((HSState.getFIFO().idle()) * (getTime() - HSState.getTime()));

	}

}

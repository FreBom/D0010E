package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
/**
 * This class holds the specific enter event, what happens when a customer arrives to the hairdress
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class Enter extends Event {

	private Customer customer;
	private double tempCutTime;
	private HairdressState HSState;

	/**
	 * Constructor assign set the time of this event and creates a new customer
	 * 
	 * @param time when event occurs
	 * @param store where the event is stored
	 */
	public Enter(double time, EventStore store) {

		super(time, store);
		this.customer = NewCustomer.create();

	}
	
	/**
	 * The effect of this event handles if the queue would be full
	 * 
	 * @param the specified state
	 * 
	 */
	public void execute(State state) {

		HSState = (HairdressState) state;

		if (!HSState.getIsClosed()) {

			HSState.setEventName(toString());
			HSState.setCustomerID(customer.getID(this.customer));

			updateWaitTime(HSState);
			updateIdleTime(HSState);
			HSState.setTime(getTime());
			HSState.update();

			if (HSState.getFIFO().idle() > 0) {
				HSState.getFIFO().addCustomer(customer);
				tempCutTime = HSState.getCutTime();
				getStore().add(new Done(customer, getTime() + tempCutTime, getStore()));
				HSState.setAverageCutTime(tempCutTime);
			} else {
				HSState.getFIFO().addNew(customer);
			}
			getStore().add(new Enter(getTime() + HSState.timeToArrival(), getStore()));
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

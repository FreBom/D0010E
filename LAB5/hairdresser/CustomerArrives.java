package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.FIFO;

public class CustomerArrives extends Event {

	private Customer customer;
	HairdressState HSState;

	/**
	 * this method creates a new customer and sets the general simulators time
	 *  
	 */
	public CustomerArrives(double time, EventStore store) {
		
		super(time, store);
		this.customer = NewCustomer.create();
		
	}

	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HSState.setEventName("Arrived");
		HSState.setTime(time);
		HSState.setCustomerID(customer.getID());
		
		
		
		if (!HSState.getIsClosed()) {

			if (HSState.getFIFO().idle() > 0) { 
				HSState.getFIFO().addCustomer(customer);
				store.add(new CustomerLeaves(customer, time + HSState.getCutTime(), store));

			} else {
				HSState.getFIFO().addNew(customer);
			} 
			store.add(new CustomerArrives(time + HSState.timeToArrival(), store));
		}
		

	}

}

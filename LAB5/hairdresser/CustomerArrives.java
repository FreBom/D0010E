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
		HSState.eventName = "Arrived";
		HSState.setTime(time);
		
		
		
		if (!HSState.getEmergencyBreak()) {

			if (HSState.idle() > 0) { 
				fifo.addCustomer(customer);
				store.add(new CustomerLeaves(customer, time + HSState.getCutTime(), store, fifo));//FIFO

			} else {
				fifo.addNew(customer);
			} 
			store.add(new CustomerArrives(time + HSState.timeToArrival(), store, fifo));//FIFO
		}

	}

}

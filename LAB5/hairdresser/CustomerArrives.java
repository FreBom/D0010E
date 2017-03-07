package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.FIFO;

public class CustomerArrives extends Event {
	// Simulator.getSimTime() + this.state.timeToArrival();
	private Customer customer;
	private HairdressState HSState;
	private EventStore store;
	
	/**
	 * this method creates a new customer and sets the general simulators time 
	 * @Question1 is <b>this.</b>customer required? Isn't customer enough?
	 * @Question2 What does the following code even do? What <b> time </b> is this? : <code> time = Simulator.getSimTime() + this.state.timeToArrival(); </code> 
	 *  
	 */
	public CustomerArrives(double time, EventStore store) {//TODO answer question 1 and 2 please.
		this.customer = NewCustomer.create();
		this.time = time;
		this.store = store;

	}

	public void execute(State state) {
		HSState = (HairdressState) state;
		HairdressState.eventName = "Arrived";
		
		
		if (!state.getEmergencyBreak()) {

			if (FIFO.idle() > 0) {
				FIFO.addCustomer(customer);
				store.add(new CustomerLeaves(customer, Simulator.getSimTime() + HSState.getCutTime(), store));

			} else {
				FIFO.addNew(customer);
			} 
			store.add(new CustomerArrives(Simulator.getSimTime() + HSState.timeToArrival(), store));
		}

	}

}

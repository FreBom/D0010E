package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.FIFO;

public class CustomerArrives extends Event {

	private Customer customer;
	private HairdressState state;
	
	/**
	 * this method creates a new customer and sets the general simulators time 
	 * @Question1 is <b>this.</b>customer required? Isn't customer enough?
	 * @Question2 What does the following code even do? What <b> time </b> is this? : <code> time = Simulator.getSimTime() + this.state.timeToArrival(); </code> 
	 *  
	 */
	public CustomerArrives() {//TODO answer question 1 and 2 please.
		this.customer = NewCustomer.create();
		time = Simulator.getSimTime() + this.state.timeToArrival();

	}

	public void execute(State state, Customer customer, EventStore store) {
		
		HairdressState.eventName = "Arrived";
		
		if (!state.getEmergencyBreak()) {

			if (FIFO.idle() > 0) {
				FIFO.addCustomer(customer);
				store.add(new CustomerLeaves(customer));

			} else {
				FIFO.addNew(customer);
			} 
			store.add(new CustomerArrives());
		}

	}

}

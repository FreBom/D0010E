package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.FIFO;

public class CustomerArrives extends Event {

	private Customer customer;
	private HairdressState state;

	public CustomerArrives() {
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

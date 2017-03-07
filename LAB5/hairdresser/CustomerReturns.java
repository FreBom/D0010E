package hairdresser;

import generalSimulator.Simulator;
import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;

public class CustomerReturns extends Event {
	
	// Simulator.getSimTime() + this.state.getReturnTime();
	private Customer customer;
	private HairdressState HSState;
	private EventStore store;
	private FIFO fifo;
	
	
	public CustomerReturns(Customer customer, double time, EventStore store, FIFO fifo){
		this.customer = customer;
		this.time = time;
		this.store = store;
		this.fifo = fifo;
		
	}
	
	public void execute(State state, Simulator sim) {
		
		HSState = (HairdressState) state;
		HairdressState.eventName = "Return";
		
		if (fifo.idle() > 0) {
			fifo.addCustomer(customer);
			store.add(new CustomerLeaves(customer, sim.getSimTime() + HSState.getCutTime(), store, fifo));

		} else {
			fifo.addOld(customer);
		} 
		
	}

}

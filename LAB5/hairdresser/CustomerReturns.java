package hairdresser;

import generalSimulator.Simulator;
import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;

public class CustomerReturns extends Event {
	
	private Customer customer;

	
	
	public CustomerReturns(Customer customer, double time, EventStore store){
		super(time, store);
		this.customer = customer;
	}
	
	public void execute(State state, Simulator sim) {
		
		HairdressState HSState = (HairdressState) state;
		HSState.eventName = "Return";
		HSState.setTime(time);
		
		if (fifo.idle() > 0) {
			fifo.addCustomer(customer);
			store.add(new CustomerLeaves(customer, time + HSState.getCutTime(), store, fifo));

		} else {
			fifo.addOld(customer);
		} 
		
	}

}
